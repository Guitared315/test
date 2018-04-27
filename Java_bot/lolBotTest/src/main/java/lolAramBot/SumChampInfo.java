package lolAramBot;

import java.util.List;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.static_data.constant.Locale;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

/*
* ユーザー名からキャラの情報を入手
*
*/

public class SumChampInfo {
	ApiConfig config = new ApiConfig().setKey(Ref.APIKEY);
	RiotApi api = new RiotApi(config);
	RiotApiAsync apiAsync = api.getAsyncApi();
	Platform platform = Platform.JP; 
	Locale locale = Locale.JA_JP;
	
	SumChampInfo(String sumName){
		this.sumName = sumName;
	}
	
	String sumName;
	long summonerId;
	
	int champId;
	String champName;
	long champMasteryPoint;
	String champImageUrl;
	String imageUrl;
	
	public void setSumChampInfo() throws RiotApiException{
		
    	//sumName to summonerID
    	Summoner summoner = api.getSummonerByName(platform,sumName);
    	summonerId = summoner.getId();
    	
    	//summonerId to masteryList
    	List<ChampionMastery> mastery = api.getChampionMasteriesBySummoner(platform, summonerId);
    	
    	//mastery to championId
    	champId = mastery.get(0).getChampionId();
   
		//mastery to masteryPoint
		champMasteryPoint = mastery.get(0).getChampionPoints();

		//favochampId to favoChampName
		net.rithms.riot.api.endpoints.static_data.dto.Champion champion = api.getDataChampion(platform, champId);
		champName = champion.getName();
		
		//チャンピオンイメージ
		champImageUrl = "https://ddragon.leagueoflegends.com/cdn/7.24.1/img/champion/" + champName + ".png";
	}

	public long getSummonerId() {
		return summonerId;
	}
	
	
}
