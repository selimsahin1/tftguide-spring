package com.example.tftguide.Crawler;

import com.example.tftguide.Model.Items;
import com.example.tftguide.Proxy.ProxyUtil;
import com.example.tftguide.Repository.ItemsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class ItemsCrawler {

    @Autowired
    ItemsRepository itemsRepository;

    private final static String ITEMS_URL = "https://lolchess.gg/items";

    private final static String ITEM_PAGE = "https://lolchess.gg/tooltip/item/";

    private final static String ITEMS_TABLE = ".ap_top_mobile+ .container";

    private String ITEM_NAME = ".text-yellow";

    private final static String ITEM_DESC1 = ".text-yellow+ div";

    private final static String ITEM_DESC2 = ".line-height-1 div";

    private final static String COMBINATION_ITEMS = ".border-secondary";

    private final static String RECOMENDED_HEROES = ".mb-1 img";

    private final static String ITEMS_TR = "tr";

    public void crawlItemsTR() {
        try {
            for (int i = 1; i <= 100; i++) {
                String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(ITEM_PAGE + i);
                Document document = Jsoup.parse(html, "https://lolchess.gg");
                Elements elements = document.getAllElements();
                String finisher = elements.select(".code").text();
                if (finisher.matches("404")) {
                    System.out.println("bitti");
                    break;
                } else {
                    Items items = new Items();
                    System.out.println(elements);
                    String itemName = elements.select(ITEM_NAME).text();
                    items.setItemName(itemName);
                    String itemDesc1 = elements.select(ITEM_DESC1).text();
                    items.setItemDescription(itemDesc1);
                    String itemDesc2 = elements.select(ITEM_DESC2).text();
                    items.setItemDescription2(itemDesc2);
                    Elements recomendedElements = elements.select(COMBINATION_ITEMS);
                    for (Element element : recomendedElements
                    ) {
                        String recomendedItem = element.select("img").attr("alt");
                        String recomendedItemImg = element.select("img").attr("src");

                        if (items.getItemCombination1() == null) {
                            items.setItemCombination1(recomendedItem);
                            items.setItemCombImg1("http:" + recomendedItemImg);
                        } else {
                            items.setItemCombination2(recomendedItem);
                            items.setItemCombImg2("http:" + recomendedItemImg);
                        }
                        System.out.println(recomendedItem);
                        System.out.println(recomendedItemImg);
                    }
                    itemsRepository.save(items);
                }
            }

            String html = new ProxyUtil().getHtmlPageFromUrlViaProxy(ITEMS_URL);
            Document document = Jsoup.parse(html, "https://lolchess.gg");
            Elements elementsForImages = document.select(".pl-2 .mr-1");
            for (Element element : elementsForImages
            ) {
                String itemName = element.select("img").attr("alt");
                String itemImg = element.select("img").attr("src");

                Items items = itemsRepository.findByItemName(itemName);
                items.setItemImage("http:" + itemImg);
                System.out.println(items);
                itemsRepository.save(items);
            }


        } catch (Exception ignored) {

        }
    }

}
