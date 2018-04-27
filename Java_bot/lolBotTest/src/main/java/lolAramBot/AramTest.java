package lolAramBot;



import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;




public class AramTest {
	public static JDA api;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {
				api = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).buildBlocking();
				api.getPresence().setGame(Game.of(""));
				api.addEventListener(new Commands());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	


}
