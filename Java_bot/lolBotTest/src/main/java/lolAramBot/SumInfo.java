package lolAramBot;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.league.constant.LeagueQueue;
import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.static_data.constant.ChampionTags;
import net.rithms.riot.api.endpoints.static_data.constant.Locale;
import net.rithms.riot.api.endpoints.static_data.dto.Image;
import net.rithms.riot.api.endpoints.static_data.methods.GetDataChampion;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.api.request.AsyncRequest;
import net.rithms.riot.api.request.RequestAdapter;
import net.rithms.riot.constant.Platform;

/*
*　ユーザー名からランクを入手
*/

public class SumInfo {

	ApiConfig config = new ApiConfig().setKey(Ref.APIKEY);
	RiotApi api = new RiotApi(config);
	RiotApiAsync apiAsync = api.getAsyncApi();
	Platform platform = Platform.JP; 
	Locale locale = Locale.JA_JP;
	ChampionTags tag = ChampionTags.ALL;
	
	
	//インナークラス
	class ExtendedSummoner {
		public Summoner summoner;
		public LeaguePosition leagueSolo;
		public LeaguePosition leagueFlexSR;
	}

	public String SumInfo(String sumName) throws RiotApiException {
		
		//サモナーネームから情報入手
		Summoner summoner = api.getSummonerByName(platform,sumName);
		
		//情報からサモナーIDを入手
		long summonerId = summoner.getId();
		
		final ExtendedSummoner eSummoner = new ExtendedSummoner();
		
		AsyncRequest requestSummoner = apiAsync.getSummoner(platform, summonerId);
		requestSummoner.addListeners(new RequestAdapter() {
			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				eSummoner.summoner = request.getDto();
			}
		});


		AsyncRequest requestLeague = apiAsync.getLeaguePositionsBySummonerId(platform, summonerId);
		requestLeague.addListeners(new RequestAdapter() {
			@Override
			public void onRequestSucceeded(AsyncRequest request) {
				Set<LeaguePosition> leaguePositions = request.getDto();
				if (leaguePositions == null || leaguePositions.isEmpty()) {
					return;
				}
				for (LeaguePosition leaguePosition : leaguePositions) {
					if (leaguePosition.getQueueType().equals(LeagueQueue.RANKED_SOLO_5x5.name())) {
						eSummoner.leagueSolo = leaguePosition;
					} else if (leaguePosition.getQueueType().equals(LeagueQueue.RANKED_FLEX_SR.name())) {
						eSummoner.leagueFlexSR = leaguePosition;
					}
					
				}
			}
		});

		try {
			apiAsync.awaitAll();
		} catch (InterruptedException e) {
			RiotApi.log.log(Level.SEVERE, "Waiting Interrupted", e);
		}

		String eSumName = eSummoner.summoner.getName();
		int eSumLevel = eSummoner.summoner.getSummonerLevel() ;

		//ソロ/デュオランク
		String solo;
		String flex;
		
		if (eSummoner.leagueSolo == null) {
			solo = "unranked";
		} else {
			solo =  eSummoner.leagueSolo.getTier() + " " + eSummoner.leagueSolo.getRank();
		}
		
		//フレックスランク
		if (eSummoner.leagueFlexSR == null) {
			flex = "unranked";
		} else {
			flex = eSummoner.leagueFlexSR.getTier() + " " + eSummoner.leagueFlexSR.getRank();
		}
		String geneSumInfo = "サモナーネーム : " + eSumName + "\r\n" +
							 "サモナーレベル : " + eSumLevel + "\r\n" +
							 "ソロ/デュオランク : " + solo + "\r\n" +
							 "フレックスランク : " + flex;
		
		return geneSumInfo;
		
	}
}
