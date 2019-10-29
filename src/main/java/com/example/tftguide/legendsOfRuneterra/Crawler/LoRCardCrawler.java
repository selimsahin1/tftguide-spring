package com.example.tftguide.legendsOfRuneterra.Crawler;

import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.legendsOfRuneterra.Model.Card;
import com.example.tftguide.legendsOfRuneterra.Model.RecomendedDecksWithCard;
import com.example.tftguide.legendsOfRuneterra.Model.SimilarCards;
import com.example.tftguide.legendsOfRuneterra.Repository.LoRCardRepository;
import com.example.tftguide.legendsOfRuneterra.Repository.RecomendedDecksWithCardRepository;
import com.example.tftguide.legendsOfRuneterra.Repository.SimilarCardsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoRCardCrawler {

    @Autowired
    LoRCardRepository loRCardRepository;

    @Autowired
    SimilarCardsRepository similarCardsRepository;

    @Autowired
    RecomendedDecksWithCardRepository recomendedDecksWithCardRepository;

    private final static String CARDS_URL = "https://rankedboost.com/legends-of-runeterra/";

    private final static String CARDS_BOX = ".card-deck-a";

    public void getAllCards() {
        try {
            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(CARDS_URL);
            Document document = Jsoup.parse(html, "https://rankedboost.com");
            Elements elements = document.select(CARDS_BOX);
            for (Element e1 : elements
            ) {
                String cardUrl = e1.select(".card-deck-a").attr("href");
                System.out.println(cardUrl);
                String html1 = new ProxyUtil().getHtmlPageFromUrlViaProxy(cardUrl);
                Document document1 = Jsoup.parse(html1, "https://rankedboost.com");
                Elements elements1 = document1.getAllElements();
                getCardDetail(elements1);
                String cardName = e1.select(".all-cards-view").attr("title");
                getAllSimilarCard(elements1, cardName);
                getAllDecksforCard(elements1, cardName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getCardDetail(Elements elements) {
        try {
            Card card = new Card();
            String cardImage = elements.select(".featured-img").attr("src");
            card.setImg(cardImage);
            String cardName = elements.select(".featured-img").attr("title");
            card.setName(cardName);
            Elements detailElements = elements.select(".uppercard-lor+ .war-li-simple .lor-details-sep-div");
            for (Element e1 : detailElements
            ) {
                Elements elements1 = e1.select("img");
                int i = 0;
                for (Element imgElement : elements1
                ) {
                    if (i == 0) {
                        String img = imgElement.select("img").attr("src");
                        String data = img.substring(img.indexOf("regions/"));
                        String editedData = data.replaceAll("regions/", "").replaceAll(".png", "");
                        card.setRegion(editedData);
                        card.setRegionImg(img);
                        i++;
                    } else if (i == 1) {
                        String img = imgElement.select("img").attr("src");
                        String data = img.substring(img.indexOf("icons/"));
                        String editedData = data.replaceAll("icons/", "").replaceAll(".png", "");
                        card.setType(editedData);
                        card.setTypeImg(img);
                        i++;
                    } else if (i == 2) {
                        String img = imgElement.select("img").attr("src");
                        String data = img.substring(img.indexOf("icons/"));
                        String editedData = data.replaceAll("icons/", "").replaceAll(".png", "");
                        card.setRarity(editedData);
                        card.setRarityImg(img);
                    }
                }
                System.out.println(elements1);
            }
            Elements detailElements2 = elements.select(".lor-details-sep-div div");
            int i = 0;
            for (Element e2 : detailElements2
            ) {
                Elements elements2 = e2.select("div");
                if (i == 0) {
                    String div = elements2.select("div").text();
                    card.setCost(div);
                    i++;
                } else if (i == 1) {
                    String div = elements2.select("div").text();
                    card.setHealth(div);
                    i++;
                } else if (i == 2) {
                    String div = elements2.select("div").text();
                    card.setPower(div);
                }
            }
            String desc = elements.select(".lor-desc-text").text();
            card.setDesc1(desc);
            String desc2 = elements.select(".lor-kw-desc").text();
            card.setDesc2(desc2);
            String desc3 = elements.select(".lor-fla-text").text();
            card.setDesc3(desc3);
//            URL url1 = new URL(cardImage);
//            byte[] imageBytes = IOUtils.toByteArray(url1);
//            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            System.out.println(desc);
            System.out.println(cardImage);
            loRCardRepository.save(card);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllSimilarCard(Elements elements, String cardName) {
        Elements cards = elements.select(".lor-assoc-card-ref-similiar");
        for (Element cardElement : cards
        ) {
            SimilarCards similarCards = new SimilarCards();
            similarCards.setCardName(cardName);
            String similarCardName = cardElement.select(".lor-assoc-card-ref-similiar").attr("title");
            similarCards.setSimilarCardName(similarCardName);
            System.out.println(similarCardName);
            similarCardsRepository.save(similarCards);
        }
    }

    private void getAllDecksforCard(Elements elements, String cardName) {
        Elements decks = elements.select(".deck-name-title");
        for (Element deckElement : decks
        ) {
            RecomendedDecksWithCard recomendedDecksWithCard = new RecomendedDecksWithCard();
            String deckName = deckElement.select(".deck-name-title").text();
            recomendedDecksWithCard.setCardName(cardName);
            recomendedDecksWithCard.setDeckName(deckName);
            recomendedDecksWithCardRepository.save(recomendedDecksWithCard);
        }
    }


}
