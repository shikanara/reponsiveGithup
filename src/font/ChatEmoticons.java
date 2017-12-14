package font;

import javax.swing.ImageIcon;

public class ChatEmoticons{
	ImageIcon smiley = new ImageIcon(getClass().getResource("/image/icons/smile.png"));
	ImageIcon winking = new ImageIcon(getClass().getResource("/image/icons/winking.png"));
	ImageIcon grin = new ImageIcon(getClass().getResource("/image/icons/grin.png"));
	ImageIcon rofl = new ImageIcon(getClass().getResource("/image/icons/rofl.png"));
	ImageIcon angry = new ImageIcon(getClass().getResource("/image/icons/angry.png"));
	ImageIcon cake = new ImageIcon(getClass().getResource("/image/icons/cake.png"));
	ImageIcon clock = new ImageIcon(getClass().getResource("/image/icons/clock.png"));
	ImageIcon cold = new ImageIcon(getClass().getResource("/image/icons/cold.png"));
	ImageIcon confused = new ImageIcon(getClass().getResource("/image/icons/confused.png"));
	ImageIcon cool = new ImageIcon(getClass().getResource("/image/icons/cool.png"));
	ImageIcon cry = new ImageIcon(getClass().getResource("/image/icons/cry.png"));
	ImageIcon dead = new ImageIcon(getClass().getResource("/image/icons/dead.png"));
	ImageIcon evil = new ImageIcon(getClass().getResource("/image/icons/evil.png"));
	ImageIcon dizzy = new ImageIcon(getClass().getResource("/image/icons/dizzy.png"));
	ImageIcon shh = new ImageIcon(getClass().getResource("/image/icons/shh.png"));
	ImageIcon drink = new ImageIcon(getClass().getResource("/image/icons/drink.png"));
	ImageIcon flower = new ImageIcon(getClass().getResource("/image/icons/flower.png"));
	ImageIcon gift = new ImageIcon(getClass().getResource("/image/icons/gift.png"));
	ImageIcon bye = new ImageIcon(getClass().getResource("/image/icons/bye.png"));
	ImageIcon heart = new ImageIcon(getClass().getResource("/image/icons/heart.png"));
	ImageIcon hug = new ImageIcon(getClass().getResource("/image/icons/hug.png"));
	ImageIcon kiss = new ImageIcon(getClass().getResource("/image/icons/kiss.png"));
	ImageIcon love = new ImageIcon(getClass().getResource("/image/icons/love.png"));
	ImageIcon music = new ImageIcon(getClass().getResource("/image/icons/music.png"));
	ImageIcon nerd = new ImageIcon(getClass().getResource("/image/icons/nerd.png"));
	ImageIcon night = new ImageIcon(getClass().getResource("/image/icons/night.png"));
	ImageIcon speechless = new ImageIcon(getClass().getResource("/image/icons/speechless.png"));
	ImageIcon party = new ImageIcon(getClass().getResource("/image/icons/party.png"));
	ImageIcon rain = new ImageIcon(getClass().getResource("/image/icons/rain.png"));
	ImageIcon angel = new ImageIcon(getClass().getResource("/image/icons/angel.png"));
	ImageIcon sad = new ImageIcon(getClass().getResource("/image/icons/sad.png"));
	ImageIcon sick = new ImageIcon(getClass().getResource("/image/icons/sick.png"));
	ImageIcon silly = new ImageIcon(getClass().getResource("/image/icons/silly.png"));
	ImageIcon smug = new ImageIcon(getClass().getResource("/image/icons/smug.png"));
	ImageIcon star = new ImageIcon(getClass().getResource("/image/icons/star.png"));
	ImageIcon poker = new ImageIcon(getClass().getResource("/image/icons/poker.png"));
	ImageIcon sun = new ImageIcon(getClass().getResource("/image/icons/sun.png"));
	ImageIcon sweat = new ImageIcon(getClass().getResource("/image/icons/sweat.png"));
	ImageIcon think = new ImageIcon(getClass().getResource("/image/icons/think.png"));
	ImageIcon vomit = new ImageIcon(getClass().getResource("/image/icons/vomit.png"));
	ImageIcon whew = new ImageIcon(getClass().getResource("/image/icons/whew.png"));
	ImageIcon yawn = new ImageIcon(getClass().getResource("/image/icons/yawn.png"));
    static final String SMILEY_E = ":)",
    		WINKING_E = ";)",
    		GRIN_E = ":D",
    		ROFL_E = "(rofl)",
    		ANGRY_E = "(angry)",
    		CAKE_E = "(cake)",
    		CLOCK_E = "(clock)",
    		COLD_E = "(cold)",
    		CONFUSED_E = "(confused)",
    		COOL_E = "(y)",
    		CRY_E = ";(",
    		DEAD_E = "(dead)",
    		EVIL_E = "(evil)",
    		DIZZY_E = "(dizzy)",
    		SHH_E = "(shh)",
    		DRINK_E = "(drink)",
    		FLOWER_E = "(flower)",//
    		GIFT_E = "(gift)",
    		BYE_E = "(bye)",
    		HEART_E = "(heart)",
    		HUG_E = "(hug)",
    		KISS_E = ":*",
    		LOVE_E = "(love)",
    		MUSIC_E = "(music)",
    		NERD_E = "(nerd)",
    		NIGHT_E = "(night)",
    		SPEECHLESS_E = ":x",
    		PARTY_E = "(party)",
    		RAIN_E = "(rain)",
    		ANGEL_E = "(angel)",
    		SAD_E = ":(",
    		SICK_E = "(sick)",
    		SILLY_E = "(silly)",
    		SMUG_E = "(smug)",
    		STAR_E = "(star)",
    		POKER_E = "(poker)",
    		SUN_E = "(sun)",
    		SWEAT_E = "(sweat)",
    		THINK_E = "(think)",
    		VOMIT_E = "(vomit)",
    		WHEW_E = "(whew)",
    		YAWN_E = "(yawn)";
	String[] emoticons = {SMILEY_E, WINKING_E, GRIN_E, ROFL_E,ANGRY_E, CAKE_E, CLOCK_E, COLD_E, CONFUSED_E, COOL_E, CRY_E, DEAD_E, EVIL_E, DIZZY_E,
    		SHH_E, DRINK_E, FLOWER_E, GIFT_E, BYE_E, HEART_E, HUG_E, KISS_E, LOVE_E, MUSIC_E, NERD_E, NIGHT_E, SPEECHLESS_E, PARTY_E, RAIN_E,
    		ANGEL_E, SAD_E, SICK_E, SILLY_E, SMUG_E, STAR_E, POKER_E, SUN_E, SWEAT_E, THINK_E, VOMIT_E, WHEW_E, YAWN_E};
	public String replace(String s){
		   s=s.replaceAll(":\\)", " :\\) ");
		   s=s.replaceAll(";\\)", " ;\\) ");
		   s=s.replaceAll(":D", " :D ");
		   s=s.replaceAll("\\(rofl\\)", " \\(rofl\\) ");
		   s=s.replaceAll("\\(angry\\)", " \\(angry\\) ");
		   s=s.replaceAll("\\(cake\\)", " \\(cake\\) ");
		   s=s.replaceAll("\\(clock\\)", " \\(clock\\) ");
		   s=s.replaceAll("\\(cold\\)", " \\(cold\\) ");
		   s=s.replaceAll("\\(confused\\)", " \\(confused\\) ");
		   s=s.replaceAll("\\(y\\)", " \\(y\\) ");
		   s=s.replaceAll(";\\(", " ;\\( ");
		   s=s.replaceAll("\\(dead\\)", " \\(dead\\) ");
		   s=s.replaceAll("\\(evil\\)", " \\(evil\\) ");
		   s=s.replaceAll("\\(dizzy\\)", " \\(dizzy\\) ");
		   s=s.replaceAll("\\(shh\\)", " \\(shh\\) ");
		   s=s.replaceAll("\\(drink\\)", " \\(drink\\) ");
		   s=s.replaceAll("\\(flower\\)", " \\(flower\\) ");
		   s=s.replaceAll("\\(gift\\)", " \\(gift\\) ");
		   s=s.replaceAll("\\(bye\\)", " \\(bye\\) ");
		   s=s.replaceAll("\\(heart\\)", " \\(heart\\) ");
		   s=s.replaceAll("\\(hug\\)", " \\(hug\\) ");
		   s=s.replaceAll(":\\*", " :\\* ");
		   s=s.replaceAll("\\(love\\)", " \\(love\\) ");
		   s=s.replaceAll("\\(music\\)", " \\(music\\) ");
		   s=s.replaceAll("\\(nerd\\)", " \\(nerd\\) ");
		   s=s.replaceAll("\\(night\\)", " \\(night\\) ");
		   s=s.replaceAll(":x", " :x ");
		   s=s.replaceAll("\\(party\\)", " \\(party\\) ");
		   s=s.replaceAll("\\(rain\\)", " \\(rain\\) ");
		   s=s.replaceAll("\\(angel\\)", " \\(angel\\) ");
		   s=s.replaceAll(":\\(", " :\\( ");
		   s=s.replaceAll("\\(sick\\)", " \\(sick\\) ");
		   s=s.replaceAll("\\(silly\\)", " \\(silly\\) ");
		   s=s.replaceAll("\\(smug\\)", " \\(smug\\) ");
		   s=s.replaceAll("\\(star\\)", " \\(star\\) ");
		   s=s.replaceAll("\\(poker\\)", " \\(poker\\) ");
		   s=s.replaceAll("\\(sun\\)", " \\(sun\\) ");
		   s=s.replaceAll("\\(sweat\\)", " \\(sweat\\) ");
		   s=s.replaceAll("\\(think\\)", " \\(think\\) ");
		   s=s.replaceAll("\\(vomit\\)", " \\(vomit\\) ");
		   s=s.replaceAll("\\(whew\\)", " \\(whew\\) ");
		   s=s.replaceAll("\\(yawn\\)", " \\(yawn\\) ");
		   s=s.replaceAll("  ", " ");
		return s;
	}
	public ImageIcon emoAction(String emoticon){
		ImageIcon re = new ImageIcon();
		switch (emoticon) {
        case SMILEY_E: re = smiley;break;
        case WINKING_E: re = winking;break;
        case GRIN_E: re = grin;break;
        case ROFL_E:re = rofl;break;
        case ANGRY_E: re = angry;break;
        case CAKE_E: re = cake;break;
        case CLOCK_E: re = clock;break;
        case COLD_E: re = cold;break;
        case CONFUSED_E: re = confused;break;
        case COOL_E: re = cool;break;
        case CRY_E: re = cry;break;
        case DEAD_E: re = dead;break;
        case EVIL_E: re = evil;break;
        case DIZZY_E: re = dizzy;break;
        case SHH_E: re = shh;break;
        case DRINK_E: re = drink;break;
        case FLOWER_E: re = flower;break;
        case GIFT_E: re = gift;break;
        case BYE_E: re = bye;break;
        case HEART_E: re = heart;break;
        case HUG_E: re = hug;break;
        case KISS_E: re = kiss;break;
        case LOVE_E: re = love;break;
        case MUSIC_E: re = music;break;
        case NERD_E: re = nerd;break;
        case NIGHT_E: re = night;break;
        case SPEECHLESS_E: re = speechless;break;
        case PARTY_E: re = party;break;
        case RAIN_E: re = rain;break;
        case ANGEL_E: re = angel;break;
        case SAD_E: re = sad;break;
        case SICK_E: re = sick;break;
        case SILLY_E: re = silly;break;
        case SMUG_E: re = smug;break;
        case STAR_E: re = star;break;
        case POKER_E: re = poker;break;
        case SUN_E: re = sun;break;
        case SWEAT_E: re = sweat;break;
        case THINK_E: re = think;break;
        case VOMIT_E: re = vomit;break;
        case WHEW_E: re = whew;break;
        case YAWN_E: re = yawn;break;
    }
		return re;
	}
	public String mousePre(int a, int b){
		String re = new String();
		switch(b){
		case 0:switch(a){
			case 0:re = ANGEL_E;break;
			case 24:re = ANGRY_E;break;
			case 48:re = BYE_E;break;
			case 72:re = CAKE_E;break;
			case 96:re = CONFUSED_E;break;
			case 120:re = COLD_E;break;
			case 144:re = CLOCK_E;break;}
			break;
		case 24:switch(a){
			case 0:re = CRY_E;break;
			case 24:re = DEAD_E;break;
			case 48:re = DIZZY_E;break;
			case 72:re = DRINK_E;break;
			case 96:re = EVIL_E;break;
			case 120:re = FLOWER_E;break;
			case 144:re = GIFT_E;break;}
			break;
		case 48:switch(a){
			case 0:re = GRIN_E;break;
			case 24:re = HEART_E;break;
			case 48:re = HUG_E;break;
			case 72:re = KISS_E;break;
			case 96:re = LOVE_E;break;
			case 120:re = MUSIC_E;break;
			case 144:re = NERD_E;break;}
			break;
		case 72:switch(a){
			case 0:re = NIGHT_E;break;
			case 24:re = PARTY_E;break;
			case 48:re = POKER_E;break;
			case 72:re = RAIN_E;break;
			case 96:re = ROFL_E;break;
			case 120:re = SAD_E;break;
			case 144:re = SHH_E;break;}
			break;
		case 96:switch(a){
			case 0:re = SICK_E;break;
			case 24:re = SILLY_E;break;
			case 48:re = SMILEY_E;break;
			case 72:re = SMUG_E;break;
			case 96:re = SPEECHLESS_E;break;
			case 120:re = STAR_E;break;
			case 144:re = SUN_E;break;}
			break;
		case 120:switch(a){
			case 0:re = SWEAT_E;break;
			case 24:re = THINK_E;break;
			case 48:re = VOMIT_E;break;
			case 72:re = WHEW_E;break;
			case 96:re = YAWN_E;break;
			case 120:re = WINKING_E;break;
			case 144:re = COOL_E;break;}
			break;
		} return re;
	}
	public Boolean eCheck(String s){
		Boolean k = false;
		if(s.length()>57) s=s.substring(0, 57);
		for(String p:emoticons){
			if(s.contains(p)) k = true;
		}
		return k;
	}
}
