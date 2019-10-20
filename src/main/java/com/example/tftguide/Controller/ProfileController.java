package com.example.tftguide.Controller;

import com.example.tftguide.Dao.Model.Profile;
import com.example.tftguide.Dao.Model.ProfileA;
import com.example.tftguide.Dao.Model.ProfileSummaryA;
import com.example.tftguide.Proxy.ProxyUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public Profile Profile(@RequestParam(required = false) String name, String region) throws IOException {

        String html = new ProxyUtil().getHtmlPageFromUrlViaProxy("https://lolchess.gg/profile/" + region + "/" + name);
        Document document = Jsoup.parse(html, "https://lolchess.gg");
        Elements elements = document.select(".profile__match-history__item");
        Profile profile = new Profile();
        List<ProfileA> profileAList = new ArrayList<>();
        for (Element element : elements
        ) {
            ProfileA profileA = new ProfileA();
            profileA.setResult(element.select(".result").text());
            profileA.setAge(element.select(".age").text());
            profileA.setTierIcon("http:" + element.select(".tier_icon").attr("src"));
            profileA.setTierName(element.select(".name").text());
            String lp = element.select(".lp dd").text();
            String[] arrOfLp = lp.split(" ", 2);
            profileA.setLp(arrOfLp[0]);
            profileA.setLpChanged((arrOfLp.length == 2) ? arrOfLp[1] : "");
            profileA.setPlayed(element.select(".plays dd").text());
            String wins = element.select(".wins dd").text();
            String[] arrOfWins = wins.split(" ", 2);
            profileA.setWins(arrOfWins[0]);
            profileA.setWinsChanged((arrOfWins.length == 2) ? arrOfWins[1] : "");
            String loses = element.select(".losses dd").text();
            String[] arrOfLoses = loses.split(" ", 2);
            profileA.setLoses(arrOfLoses[0]);
            profileA.setLosesChanged((arrOfLoses.length == 2) ? arrOfLoses[1] : "");
            String winRate = element.select(".winrate-pc dd").text();
            String[] arrOfWinRate = winRate.split(" ", 2);
            profileA.setWinRate(arrOfWinRate[0]);
            profileA.setWinRateChanged((arrOfWinRate.length == 2) ? arrOfWinRate[1] : "");
            System.out.println(element);
            profileAList.add(profileA);
        }
        //.row-normal:nth-child(1)
        Elements elements2 = document.select(".row-normal:nth-child(1)");
        ProfileSummaryA profileSummaryA = new ProfileSummaryA();
        for (Element element : elements2
        ) {
            profileSummaryA.setTierImage("http:" + element.select("img").attr("src"));
            profileSummaryA.setTier(element.select(".text-challenger").text());
            profileSummaryA.setLp(element.select(".profile__tier__summary__lp").text());
            profileSummaryA.setRank(element.select(".rank-region").text());
            profileSummaryA.setTierPercent(element.select(".top-percent").text());
            profileSummaryA.setPlayed(element.select(".col-6:nth-child(1) .float-right").text());
            profileSummaryA.setPlayedPercent(element.select(".col-6:nth-child(1) .profile__tier__stat__text").text());
            profileSummaryA.setWinRate(element.select(".col-6:nth-child(2) .float-right").text());
            profileSummaryA.setWinRatePercent(element.select(".col-6:nth-child(2) .profile__tier__stat__text").text());
            profileSummaryA.setWins(element.select(".col-6:nth-child(3) .float-right").text());
            profileSummaryA.setWinsPercent(element.select(".col-6:nth-child(3) .profile__tier__stat__text").text());
            profileSummaryA.setLoses(element.select(".col-6:nth-child(4) .float-right").text());
            profileSummaryA.setLosesPercent(element.select(".col-6:nth-child(4) .profile__tier__stat__text").text());

        }

        Elements elements3 = document.select(".profile__header");
        for (Element element : elements3
        ) {
            profileSummaryA.setAvatar("http:" + element.select("img").attr("src"));
            profileSummaryA.setName(element.select(".profile__summoner__name").text());
        }

        profile.setProfileAList(profileAList);
        profile.setProfileSummaryA(profileSummaryA);
        return profile;
    }

}
