//Afshana Falza and Jacinda Soto
import java.util.ArrayList;
import java.applet.*;

public class Game
{
    //instance variables
    //grid stuff  
    private Grid grid;
    private int userRow;
    private int userCol;
    static String[][] bg;
    private int surRow;
    private int surCol;
    private boolean enableBoss;
    
    //point stuff
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    
    //wall stuff
    private String lefW;
    private String rigW;
    private String topW;
    private String botW;
    private String corW;
    private String lewR;
    private String riwR;
    private String towR;
    private String bowR;
    private String wboW;
    private String wleW;
    private String wcoW;
    private String wriW;
    private String wtoW;

    //evil E
    //stuff
    private ArrayList<EvilE> enemies;
    
    //E pngs
    private String teaE; //teacher E 
    private String devE; //devil E 
    private String spoE; //sporty E 
    private String makE; //makeup E
    private String bbgE; // baby girl E
    private String bbbE; //baby boy E
    private String sleE; //sleepy E
    private String skaE; //skater E
    private String nerE; //nerdy E
    private String emoE; //emo E
    private String ganE; //gangsta E
    private String robE; //robot
    private String robo; //robot still
    
    //E gifs
    private String shDE; //devil E
    private String sBBE; //baby boy E
    private String sBGE; //baby girl E
    private String sSLE; //sleepy E

    //user things
    private boolean isGirl; //determines user's gender
    private String user; //user png
    private String walk; //user walking gif
    private String tempUser;
    
    //characters
    private String nurs;
    private String suri;
    private String chan;
    private String suriStand;
    private String suriWalk;
    private String kimm;
    private String luLa;
    
    //other
    private int bgInt;
    private String levr;
    private String strs;
    private String strW;
    private boolean goStairs;
    private String chaL;
    private String chaR;
    private String wstW;
    private String wsts;
    private String desL;
    private String desR;
            
    //other obstacles
    private String fire;
    private String noFi;
    private String rock;
    private String noRo;
    private String bats;
    private String noBa;
    
    //health
    static int health;
    private String full;
    private String empt;
    
    //music audio
    private AudioClip introSong;
    private AudioClip gameOver;
    private AudioClip calm;
    private AudioClip suspense;
    private AudioClip leverSound;
    private AudioClip yayTada;
    private AudioClip ouch;
    private AudioClip creepy;
    private AudioClip npcGreet;
    private AudioClip bg1;
    private AudioClip echeer;
    private AudioClip hint;
    private AudioClip sspeech;
    private AudioClip menScr;
    private AudioClip cry;
    private AudioClip s1;
    private AudioClip s2;
    private AudioClip s3;
    private AudioClip s4;
    private AudioClip s5;
    private AudioClip s6;
    private AudioClip s7;
    private AudioClip s8;
    private AudioClip s9;
    private AudioClip s10;
    private AudioClip s11;
    private AudioClip s12;
    private AudioClip viny;
                            

    
    //cutscene
    private int csCount;
    private boolean aftHin;
            
    //menu screen stuff
    private String menPlay;
    private String menCont;
    private String menAud;
    private String menGal;
    private String mute;
    private String unmute;
    static boolean isMute;
    private int menNum;
    private int musicCount;
    private int conCount;
    
    private int chanCount;
    private int nursCount;
    private int kimCount;
    private int lulaCount;
    
    //floor holes
    private String puHo, woHo, grHo, gnHo, blHo;
    private String toLe, toRi, boLe, boRi;
    
    //nurse stuff
    private String hBeL,hBeR;
    
    //sum decoration
    private String tedy;
    private String mony;
    private String skaR, skaB, ska2;
    private String caTL, caTR, caBL, caBR;
    private String blok;
    private String flyb;
    private String loHo, loHB, loHT;
    private String fiBa;
    private String vBal;
    private String deLS;
    private String deRS;
    private String chLS;
    private String chRS;
    private String reHo;
    private String aidK;
    
    
    //idk
    private boolean surTalk;
    private boolean surStill;
    
    private int songCount;
    private int credCount;
    
    public Game()
    {
        //grid stuff  
        grid = new Grid(10, 14);
        userRow = 1;
        userCol = 1;
        surRow = 1;
        surCol = 1;
        enableBoss = false;
        
        //point stuff
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        
        //wall stuff
        lefW = "leftwall.png";
        rigW = "rightwall.png";
        topW = "topwall.png";
        botW = "bottomwall.png";
        corW = "wallcorner.png";
        lewR = "leftwallr.png";
        riwR = "rightwallr.png";
        towR = "topwallr.png";
        bowR = "bottomwallr.png";
        wboW = "woodbottomwall.png";
        wleW = "woodleftwall.png";
        wcoW = "woodwallcorner.png";
        wriW = "woodrightwall.png";
        wtoW = "woodtopwall.png";
        
        //E stuff
        devE = "devilE.png";
        teaE = "teacherE.png";
        spoE = "sportyE.png";
        makE = "makeupE.png";
        bbgE = "babyGE.png";
        bbbE = "babyBE.png";
        sleE = "sleepyE.png";
        skaE = "skaterE.png";
        nerE = "nerdyE.png";
        emoE = "emoE.png";
        ganE = "gangstaE.png";
        robE = "robotE.gif";
        robo = "robo.gif";
        
        //E gif
        shDE = "shakeDE.gif";
        sBBE = "shakeBBE.gif";
        sBGE = "shakeBGE.gif";
        sSLE = "shakeSLE.gif";
        
        //user gender stuff
        if(isGirl == false) //if boy
        {
            user = "userB.png";
            walk = "userBW.gif";
            tempUser = "userB.png";
        }
        else //if girl
        {
            user = "userG.png";
            walk = "userGW.gif";
            tempUser = "userB.png";
        }
        
        //obstacles
        fire = "fire.gif";
        noFi = "out.gif";
        rock = "rock.gif";
        noRo = "break.gif";
        bats = "bats.gif";
        noBa = "bye.gif";
        
        //health
        health = 4;
        full = "fullwall.png";
        empt = "emptywall.png";
        
        //music audio
        introSong = Applet.newAudioClip(this.getClass().getResource("bowsermusicSE.wav"));
        gameOver = Applet.newAudioClip(this.getClass().getResource("failSE.wav"));
        calm = Applet.newAudioClip(this.getClass().getResource("minecraftcalmSE.wav"));
        suspense = Applet.newAudioClip(this.getClass().getResource("suspenseSE.wav"));
        leverSound = Applet.newAudioClip(this.getClass().getResource("leverSE.wav"));
        yayTada = Applet.newAudioClip(this.getClass().getResource("tadaSE.wav"));
        ouch = Applet.newAudioClip(this.getClass().getResource("ouchSE.wav"));
        creepy = Applet.newAudioClip(this.getClass().getResource("dramaticSE.wav"));
        npcGreet = Applet.newAudioClip(this.getClass().getResource("meetnpcSE.wav"));
        bg1 = Applet.newAudioClip(this.getClass().getResource("background1SE.wav"));
        echeer = Applet.newAudioClip(this.getClass().getResource("echeerSE.wav"));
        hint = Applet.newAudioClip(this.getClass().getResource("hintSE.wav"));
        sspeech = Applet.newAudioClip(this.getClass().getResource("surielspeechSE.wav"));
        menScr = Applet.newAudioClip(this.getClass().getResource("menuSE.wav"));
        cry = Applet.newAudioClip(this.getClass().getResource("babySE.wav"));
        s1 = Applet.newAudioClip(this.getClass().getResource("1s.wav"));
        s2 = Applet.newAudioClip(this.getClass().getResource("2s.wav"));
        s3 = Applet.newAudioClip(this.getClass().getResource("3s.wav"));
        s4 = Applet.newAudioClip(this.getClass().getResource("4s.wav"));
        s5 = Applet.newAudioClip(this.getClass().getResource("5s.wav"));
        s6 = Applet.newAudioClip(this.getClass().getResource("6s.wav"));
        s7 = Applet.newAudioClip(this.getClass().getResource("7s.wav"));
        s8 = Applet.newAudioClip(this.getClass().getResource("8s.wav"));
        s9 = Applet.newAudioClip(this.getClass().getResource("9s.wav"));
        s10 = Applet.newAudioClip(this.getClass().getResource("10s.wav"));
        s11 = Applet.newAudioClip(this.getClass().getResource("11s.wav"));
        s12 = Applet.newAudioClip(this.getClass().getResource("12s.wav"));
        viny = Applet.newAudioClip(this.getClass().getResource("vinnysong.wav"));
        
        //characters
        nurs = "nurse.png";
        chan = "chan.png";
        suriWalk = "surielW.gif";
        suriStand = "suriel.png";
        suri = suriStand;
        kimm = "kim.png";
        luLa = "lunchlady.png";
        
        //other  
        levr = "lever.png";
        strs = "stairsdown.png";
        strW = "swall.png";
        goStairs = true;
        chaL = "chairL.png";
        chaR = "chairR.png";
        wsts = "woodstairsdown.png";
        wstW = "woodswall.png";
        desL = "deskL.png";
        desR = "deskR.png";
        
        //cscount
        csCount = 0;
        aftHin = false;
        
        //menu stuff
        menPlay = "playmenu.png"; //0
        menCont = "controlsmenu.png"; //1
        menAud = "audiomenu.png"; //2
        menGal = "gallerymenu.png"; //3
        mute = "mute.png";
        unmute = "unmute.png";
        isMute = false;
        menNum = 0;
        musicCount = 0;
        conCount = 0;
               
        //levels
        menuScreen();
        //decideGender();
        //setupLevel1();
        
        chanCount = 0;
        nursCount = 0;
        kimCount = 0;
        lulaCount = 0;
        //hole stuff
        puHo = "purphole.png";
        woHo = "woodhole.png";
        grHo = "greyhole.png";
        gnHo = "greenhole.png";
        blHo = "bluehole.png";
        toLe = "holeTL.png";
        toRi = "holeTR.png";
        boLe = "holeBL.png";
        boRi = "holeBR.png";

        //other
        hBeL = "hosbedL.png";
        hBeR = "hosbedR.png";

        //decor
        tedy = "teddy.gif";
        mony = "money.png";
        skaR = "skate1.png";
        skaB = "skate2.png";
        ska2 = "skates.png";
        caTL = "tabRU.png";
        caTR = "tabLU.png";
        caBL = "tabRD.png";
        caBR = "tabLD.png";
        blok = "nothing.png";
        flyb = "bookE.gif";
        vBal = "vBallE.gif";
        fiBa = "firewormE.gif";
        loHo = "longhole.png";
        loHB = "longholeB.png";
        loHT = "longholeT.png";
        deLS = "deskLS.png";
        deRS = "deskRS.png";
        chLS = "chairleftS.png";
        chRS = "chairrightS.png";
        
        //idk
        surTalk = false;
        surStill = false;
        aidK = "aid.png";
        reHo = "redhole.png";
        
        songCount = 0;
        credCount = 0;
    }
    
    public boolean getMute()
    {
        return isMute;
    }
    
    public void menuScreen()
    {
        
        bgInt = -1;
        
        if(!isMute && musicCount<1)
        {
            calm.play();
            musicCount++;
            //System.out.println("MUSIC COUNT IS @@@@@@@@@@@@"+musicCount);
        }
        
        if(isMute)
        {
            musicCount=0;
            calm.stop();
        }
        
        if(menNum==0)
        {
            grid.setBackground(menPlay);
        }
        else if(menNum==1)
        {
            grid.setBackground(menCont);            
        }
        else if(menNum==2)
        {
            grid.setBackground(menAud);
        }
        else if(menNum==3)
        {
            grid.setBackground(menGal);
        }
        else if(menNum==4)
        {
            grid.setBackground(mute);
        }
        else if(menNum==5)
        {
            grid.setBackground(unmute);
        }
        else if(menNum==6)
        {
            grid.setBackground("space1.png");
        }
        else if(menNum==7)
        {
            grid.setBackground("space2.png");
        }
        else if(menNum==8)
        {
            grid.setBackground("space3.png");
        }
        else if(menNum==9)
        {
            grid.setBackground("arrows.png");
        }
        else if(menNum==10)
        {
            grid.setBackground("escape.png");
        }
        else if(menNum==11)
        {
            grid.setBackground("gallery.png");
        }
    }
    
    public void decideGender()
    {
        bgInt = 0;
        grid.setBackground("chooseMenu.png");
        grid.setGender(isGirl);
        grid.setBlinkRec(true);
    }
    
    //mutator for health
    public void setHealth(int h)
    {
        health = h;
    }
    
    //changes hearts on display
    public void displayHearts()
    {
        int startIndex = 5;
        int maxHealth = 4;

        for (int i = 0; i < maxHealth; i++)
        {
            if (i < health)
            {
                bg[0][i+startIndex] = full;
            }
            else 
            {
                bg[0][i+startIndex] = empt;
            }
        }
    }
    
    //method for level 1
    //introduces suriel
    public void setupLevel1()
    {
        if(!isMute)
        {
            sspeech.loop();
            calm.stop();
        }
        
        grid.setCutscene(true);
                
        bgInt = 1;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("floor.png");

        //making the 2D array and creating walls
        String[][] bg = {{corW, topW, topW, topW, topW, full, full, full, full, topW, topW, topW, topW, corW},
                         {lefW, null, null, null, null, "bats.gif", suri, "bats.gif", null, null, null, null, null, rigW},
                         {lefW, spoE, bbgE, devE, ganE, skaE, null, emoE, bbbE, nerE, teaE, makE, sleE, rigW},
                         {lefW, sleE, teaE, emoE, spoE, makE, null, devE, ganE, bbgE, skaE, bbbE, nerE, rigW},
                         {lefW, nerE, ganE, bbgE, skaE, spoE, null, bbbE, emoE, makE, devE, sleE, teaE, rigW},
                         {lefW, teaE, devE, spoE, makE, bbgE, null, bbbE, sleE, skaE, nerE, emoE, ganE, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r = 0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                System.out.println("curr = " + curr);
                /*if(curr != null && curr.equals(bbgE))
                {
                    EvilE aBGE = new EvilE(r, c, bbgE, "leftAndRight", "right");
                    enemies.add(aBGE);
                }
                else if(curr != null &&curr.equals(bbbE))
                {
                    EvilE aBBE = new EvilE(r, c, bbbE, "leftAndRight", "left");
                    enemies.add(aBBE);
                }*/
            }
        }
    }
    
    //level 2
    //introduces fire
    public void setupLevel2()
    {        
        grid.setCutscene(true);

        bgInt = 2;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("woodfloor.png");

        //making the 2D array and creating walls
        String[][] bg = {{corW, topW, topW, topW, topW, full, full, full, full, topW, topW, topW, topW, corW},
                         {lefW, user, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, woHo, null, null, null, null, null, null, null, fire, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, fire, fire, rigW},
                         {lefW, levr, null, null, null, null, null, null, null, null, null, fire, null, strs},
                         {lefW, null, null, toLe, toRi, null, null, null, null, woHo, null, fire, fire, rigW},
                         {lefW, null, null, boLe, boRi, null, woHo, null, null, null, null, null, fire, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};

        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        //userRow = 5;
        //userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;

        //iterating throug1h nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals("fireE.gif"))
                {
                    EvilE aSLE = new EvilE(r, c, "fireE.gif", "leftAndRight", "right");
                    enemies.add(aSLE);
                }
            }
        } 
    }

    //level 3
    //introduces baby E's
    public void setupLevel3()
    {
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 3;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("woodfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, bbgE, null, null, null, bbgE, null, null, null, bbgE, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, fire, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, fire, fire, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, fire, null, null, null, null, null, null, null, null, null, strs},
                         {lefW, null, null, null, fire, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, fire, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, levr, null, fire, bbbE, null, null, null, bbbE, null, null, null, bbbE, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        surRow = 4;
        surCol = 7;
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(bbgE))
                {
                    EvilE abGE = new EvilE(r, c, bbgE, "upAndDown", "down");
                    enemies.add(abGE);
                }
                else if(curr != null && curr.equals(bbbE))
                {
                    EvilE abbE = new EvilE(r, c, bbbE, "upAndDown", "up");
                    enemies.add(abbE);
                }
            }
        } 
    }
    
    //introduce
    public void setupLevel4()
    {
        enableBoss = false;

        if(!isMute)
        {
            cry.stop();
        }
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 4;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("woodfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, levr, null, null, null, null, null, null, null, fire, null, null, sleE, rigW},
                         {lefW, null, null, null, fire, null, null, null, null, null, null, null, null, rigW},
                         {lefW, sleE, null, null, null, null, fire, null, fire, null, fire, null, null, rigW},
                         {lefW, null, null, null, null, fire, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, fire, null, null, fire, null, null, fire, null, fire, null, strs},
                         {lefW, null, null, null, null, fire, null, fire, null, null, null, null, null, rigW},
                         {lefW, sleE, null, null, null, null, null, null, null, null, null, null, fire, rigW},
                         {lefW, null, null, null, fire, null, null, null, fire, null, null, null, sleE, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(sleE))
                {
                    EvilE aslE = new EvilE(r, c, sleE, "leftAndRight", "right");
                    enemies.add(aslE);
                }
            }
        }     
    }
       
    //introduce nerdE
    public void setupLevel5()
    {
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 5;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("woodfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, fire, nerE, flyb, null, null, nerE, flyb, null, null, nerE, flyb, fire, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, null, null, null, null, null, strs},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, fire, null, null, nerE, flyb, null, null, nerE, flyb, null, null, fire, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(nerE))
                {
                    EvilE anerE = new EvilE(r, c, nerE, "upAndDown", "down");
                    enemies.add(anerE);
                }
                else if(curr != null && curr.equals(flyb))
                {
                    EvilE aflyb = new EvilE(r, c, flyb, "upAndDown", "down");
                    enemies.add(aflyb);
                }
            }
        }     
    }
    
    //chans level
    public void setupLevel6()
    {
        goStairs = false;
        
        grid.nextCutscene();

        grid.setCutscene(true);
          
        if(!isMute)
        {
            hint.play();
            s1.stop();
            s2.loop();
        }
        
        bgInt = 6;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("woodfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, chaL, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, desL, desR, null, null, desL, desR, null, null, chaL, null, rigW},
                         {lefW, null, null, chaL, chaR, null, null, chaL, chaR, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, null, null, null, chan, null, strs},
                         {lefW, null, null, desL, desR, null, null, desL, desR, null, null, null, null, rigW},
                         {lefW, null, null, chaL, chaR, null, null, chaL, chaR, null, chaR, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(nerE))
                {
                    EvilE anerE = new EvilE(r, c, nerE, "upAndDown", "down");
                    enemies.add(anerE);
                }
            }
        }     
    }
    
    //makeup E
    public void setupLevel7()
    {        
        if(!isMute)
        {
            s2.stop();
            s3.loop();
        }
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 7;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("purpfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, loHo, makE, loHo, null, loHo, makE, loHo, null, loHo, makE, loHo, rigW},
                         {lefW, null, loHo, null, loHo, null, loHo, null, loHB, null, loHo, null, loHo, rigW},
                         {lefW, null, loHo, null, loHB, null, loHo, null, null, null, loHo, null, loHB, rigW},
                         {lefW, tedy, loHB, null, null, null, loHo, null, loHT, null, loHo, null, tedy, rigW},
                         {strW, user, null, null, loHT, null, loHo, null, loHo, null, loHB, null, null, strs},
                         {lefW, tedy, loHT, null, loHo, null, loHo, null, loHo, null, null, null, tedy, rigW},
                         {lefW, null, loHo, null, loHo, null, loHB, null, loHo, null, loHT, null, loHT, rigW},
                         {lefW, null, loHo, null, loHo, makE, null, null, loHo, makE, loHo, null, loHo, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(makE))
                {
                    EvilE amakE = new EvilE(r, c, makE, "upAndDown", "down");
                    enemies.add(amakE);
                }
            }
        }     
    }
    
    //sporty
    //VIANNEYS LEVEL
    public void setupLevel8()
    {        
        if(!isMute)
        {
            s3.stop();
            viny.play();
        }
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 8;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("purpfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, robo, vBal, null, null, null, null, null, null, null, null, null, robo, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, puHo, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, robE, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, null, null, spoE, null, null, strs},
                         {lefW, null, null, null, null, null, null, null, null, null, robE, null, null, rigW},
                         {lefW, null, null, null, null, null, puHo, null, null, null, null, null, null, rigW},
                         {lefW, robo, null, null, null, null, null, null, null, null, null, vBal, robo, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(spoE))
                {
                    EvilE aspoE = new EvilE(r, c, spoE, "leftAndRight", "left");
                    enemies.add(aspoE);
                }
                if(curr!=null && curr.equals(robE))
                {
                    EvilE arobE = new EvilE(r, c, robE, "leftAndRight", "left");
                    enemies.add(arobE);
                }
                if(curr!=null && curr.equals(vBal))
                {
                    EvilE avBal = new EvilE(r, c, vBal, "leftAndRight", "right");
                    enemies.add(avBal);
                }
            }
        }     
    }
    
    //NURSE LEVEL
    public void setupLevel9()
    {        
        if(!isMute)
        {
            viny.stop();
            s4.loop();
        }
        goStairs = false;
        
        //grid.nextCutscene();

        //grid.setCutscene(true);
                
        bgInt = 9;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("purpfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, hBeL, hBeR, aidK, null, aidK, hBeL, hBeR, aidK, null, aidK, hBeL, hBeR, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, null, null, null, nurs, null, strs},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, hBeL, hBeR, aidK, null, aidK, hBeL, hBeR, aidK, null, aidK, hBeL, hBeR, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(spoE))
                {
                    EvilE aspoE = new EvilE(r, c, spoE, "upAndDown", "down");
                    enemies.add(aspoE);
                }
            }
        }     
    }
    
    //skater
    public void setupLevel10()
    {            
        if(!isMute)
        {
            s4.stop();
            s5.loop();
        }
        
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 10;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("greenfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, null, null, null, null, skaR, null, null, null, skaE, null, null, rigW},
                         {lefW, null, gnHo, skaE, null, null, null, null, null, gnHo, null, null, skaB, rigW},
                         {lefW, ska2, null, null, null, null, null, skaB, null, null, null, null, null, rigW},
                         {lefW, null, null, null, skaE, null, toLe, toRi, null, null, skaB, null, null, rigW},
                         {strW, user, null, null, skaB, null, boLe, boRi, null, null, null, skaE, null, strs},
                         {lefW, null, null, skaE, null, null, null, null, null, skaR, null, gnHo, null, rigW},
                         {lefW, ska2, null, gnHo, null, null, null, null, skaB, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, skaE, null, skaR, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(skaE))
                {
                    EvilE askaE = new EvilE(r, c, skaE, "leftAndRight", "left");
                    enemies.add(askaE);
                }
            }
        }     
    }
    
    //emo
    public void setupLevel11()
    {                
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 11;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("greenfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, bats, null, null, emoE, null, null, bats, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, levr, null, null, null, null, gnHo, null, bats, null, null, null, bats, rigW},
                         {lefW, null, null, bats, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, bats, null, null, null, null, null, emoE, null, strs},
                         {lefW, null, bats, null, null, null, null, bats, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, emoE, null, null, null, gnHo, null, null, null, rigW},
                         {lefW, emoE, null, null, gnHo, null, bats, null, null, null, null, bats, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};

        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(emoE))
                {
                    EvilE aemoE = new EvilE(r, c, emoE, "diagonal", "diagUpR");
                    enemies.add(aemoE);
                }
            }
        }     
    }
    
    //kim
    public void setupLevel12()
    {                
        if(!isMute)
        {
            s5.stop();
            s6.loop();
        }
        goStairs = false;
        
        //grid.nextCutscene();

        //grid.setCutscene(true);
                
        bgInt = 12;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("greenfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, null, null, null, null, null, null, chRS, null, null, null, loHT, rigW},
                         {lefW, gnHo, null, loHT, null, null, null, null, null, null, gnHo, null, loHo, rigW},
                         {lefW, null, null, loHo, null, null, gnHo, null, null, null, null, null, loHB, rigW},
                         {lefW, null, null, loHB, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, gnHo, null, null, kimm, null, strs},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, gnHo, null, chLS, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, gnHo, null, null, deLS, deRS, null, gnHo, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(emoE))
                {
                    EvilE aemoE = new EvilE(r, c, emoE, "upAndDown", "up");
                    enemies.add(aemoE);
                }
            }
        }     
    }

    //teacher
    public void setupLevel13()
    {         
        if(!isMute)
        {
            s6.stop();
            s7.loop();
        }
        //goStairs = false;
        
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 13;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("bluefloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, null, null, null, null, null, null, chLS, deLS, deRS, chRS, null, rigW},
                         {lefW, null, deLS, deRS, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, chLS, chRS, teaE, null, null, blHo, null, null, null, null, teaE, rigW},
                         {lefW, null, null, teaE, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, blHo, null, teaE, null, chLS, null, teaE, null, strs},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, chLS, teaE, null, null, deLS, deRS, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, chLS, null, blHo, null, null, null, chRS, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(teaE))
                {
                    EvilE ateaE = new EvilE(r, c, teaE, "diagonal", "diagDownR");
                    enemies.add(ateaE);
                }
            }
        }     
    }

    //gangster
    public void setupLevel14()
    {                
        //goStairs = false;
        
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 14;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("bluefloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, null, null, null, null, null, null, null, ganE, mony, null, null, rigW},
                         {lefW, ganE, null, null, mony, null, null, null, null, null, blHo, null, null, rigW},
                         {lefW, null, null, blHo, null, null, null, ganE, null, null, null, null, null, rigW},
                         {lefW, mony, null, null, null, null, null, null, null, null, null, null, mony, rigW},
                         {strW, user, null, null, null, ganE, blHo, null, mony, null, null, ganE, null, strs},
                         {lefW, mony, null, null, null, null, null, null, ganE, null, null, null, mony, rigW},
                         {lefW, null, null, null, ganE, null, null, null, null, null, blHo, null, null, rigW},
                         {lefW, null, blHo, mony, null, null, null, ganE, null, null, null, mony, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(ganE))
                {
                    EvilE aganE = new EvilE(r, c, ganE, "leftAndRight", "left");
                    enemies.add(aganE);
                }
            }
        }     
    }

    public void setupLevel15()
    {                
        if(!isMute)
        {
            s7.stop();
            s8.loop();
        }
        goStairs = false;
        
        //grid.nextCutscene();

        //grid.setCutscene(true);
                
        bgInt = 15;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("tilefloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, null, null, null, null, null, caTR, caTL, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, caBR, caBL, null, null, null, null, rigW},
                         {lefW, null, null, caTR, caTL, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, caBR, caBL, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, null, null, null, luLa, null, strs},
                         {lefW, null, null, null, null, null, null, null, caTR, caTL, null, null, null, rigW},
                         {lefW, null, null, null, caTR, caTL, null, null, caBR, caBL, null, null, null, rigW},
                         {lefW, null, null, null, caBR, caBL, null, null, null, null, null, null, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(emoE))
                {
                    EvilE aemoE = new EvilE(r, c, emoE, "upAndDown", "up");
                    enemies.add(aemoE);
                }
            }
        }     
    }

    //devil
    public void setupLevel16()
    {            
        if(!isMute)
        {
            s8.stop();
            s9.loop();
        }
        //goStairs = false;
        
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 16;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("redfloor.png");

        //making the 2D array and creating walls

        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, devE, null, null, null, null, fire, null, null, reHo, null, null, null, rigW},
                         {lefW, reHo, null, null, fiBa, null, null, null, null, fiBa, null, null, null, rigW},
                         {lefW, fire, null, reHo, null, null, null, null, devE, null, fire, null, null, rigW},
                         {lefW, null, null, null, null, fiBa, fiBa, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, devE, devE, null, null, null, reHo, null, null, strs},
                         {lefW, null, null, null, null, fiBa, fiBa, null, null, null, null, null, null, rigW},
                         {lefW, null, reHo, devE, null, null, null, null, null, null, null, fire, null, rigW},
                         {lefW, null, null, null, fire, null, null, reHo, null, fire, null, null, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(devE))
                {
                    EvilE adevE = new EvilE(r, c, devE, "leftAndRight", "left");
                    enemies.add(adevE);
                }
                if(curr != null && curr.equals(fiBa))
                {
                    EvilE afiBa = new EvilE(r, c, fiBa, "leftAndRight", "left");
                    enemies.add(afiBa);
                }
            }
        }     
    }

    //suriel boss
    public void setupLevel17()
    {            
        if(!isMute)
        {
            s9.stop();
            s10.loop();
        }
        grid.nextCutscene();

        grid.setCutscene(true);
                
        bgInt = 17;
        
        enemies = new ArrayList<EvilE>();

        //grid.setImage(new Location(userRow, userCol), "user.gif");

        //this sets the background as the floor
        grid.setBackground("greyfloor.png");

        //making the 2D array and creating walls
        
        enableBoss = true;


        String[][] bg = {{corW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, topW, corW},
                         {lefW, null, null, devE, null, null, null, emoE, null, deLS, deRS, chRS, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, levr, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {strW, user, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, ganE, null, null, null, null, null, rigW},
                         {lefW, null, null, null, null, null, null, null, null, null, null, null, skaE, rigW},
                         {lefW, teaE, null, null, null, null, null, null, null, null, null, null, null, rigW},
                         {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
        
        //moves user back to starting position
        grid.setImage(new Location(userRow,userCol), null);
        bg[userRow][userCol] = null;
        userRow = 5;
        userCol = 1;
        grid.setImage(new Location(userRow, userCol), user);
        bg[userRow][userCol] = user;
                            
        this.bg=bg;
        
        //iterating through nested for loops
        for(int r=0; r < bg.length; r++)
        {
            for(int c = 0; c < bg[0].length; c++)
            {

                grid.setImage(new Location(r, c), bg[r][c]);
                String curr = grid.getImage(new Location(r,c));
                //System.out.println("curr = " + curr);
                if(curr != null && curr.equals(devE))
                {
                    EvilE adevE = new EvilE(r, c, devE, "leftAndRight", "left");
                    enemies.add(adevE);
                }
                else if(curr != null && curr.equals(emoE))
                {
                    EvilE aemoE = new EvilE(r, c, emoE, "diagonal", "diagDownR");
                    enemies.add(aemoE);
                }
                else if(curr != null && curr.equals(teaE))
                {
                    EvilE ateaE = new EvilE(r, c, teaE, "diagonal", "diagUpR");
                    enemies.add(ateaE);
                }
                else if(curr != null && curr.equals(ganE))
                {
                    EvilE aganE = new EvilE(r, c, ganE, "leftAndRight", "left");
                    enemies.add(aganE);
                }
                else if(curr != null && curr.equals(skaE))
                {
                    EvilE askaE = new EvilE(r, c, skaE, "leftAndRight", "left");
                }
            }
        }     
    }
    
    public void setupCredits()
    {
        bgInt = 18;
        
        credCount++;
        if(credCount==1)
        {
            if(!isMute)
            {
                //credCount++;
                System.out.println("THIS HAS HAPPENED!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                //if(credCount==1)
                //{
                    s11.stop();
                    s12.loop();
                //}
            }

            grid.setBackground("credits.png");
            for(int r=0;r<bg.length;r++)
            {
                for(int c=0;c<bg[0].length;c++)
                {
                    grid.setImage(new Location(r, c), null);
                    bg[r][c] = null;
                }
            }
        }
    }
        
    //SURIEL BOSS LEVEL CODE
    //x placements
    //300x150 (3 by 6) 500 x 100 (2 by 10) 400 x 300 (6 by 8)
//    //this sets the background as the floor
//    grid.setBackground("greyfloor.png");
//
//    //making the 2D array and creating walls
//    String[][] bg = {{corW, topW, topW, topW, topW, full, full, full, full, topW, topW, topW, topW, corW},
//                     {lefW, user, null, null, null, null, null, null, null, null, null, null, null, rigW},
//                     {lefW, null, null, null, null, null, null, null, null, null, blok, null, null, rigW},
//                     {lefW, null, null, null, woHo, null, blok, null, null, null, null, null, fire, rigW},
//                     {lefW, null, null, null, null, null, null, null, null, null, null, fire, fire, rigW},
//                     {lefW, levr, null, null, null, null, null, null, null, null, null, fire, null, strs},
//                     {lefW, null, null, toLe, toRi, null, null, null, blok, woHo, null, fire, fire, rigW},
//                     {lefW, null, null, boLe, boRi, null, woHo, null, null, null, null, null, fire, rigW},
//                     {lefW, null, null, null, null, null, null, null, null, null, null, null, null, rigW},
//                     {corW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, botW, corW}};
//

    //this method returns true or false depending on if suriel is on the x
    public boolean onX()
    {
        if(grid.getImage(new Location(3, 6))!=null && grid.getImage(new Location(3, 6)).equals(suri) || grid.getImage(new Location(2, 10))!=null && grid.getImage(new Location(2, 10)).equals(suri) || grid.getImage(new Location(6, 8))!=null && grid.getImage(new Location(6, 8)).equals(suri))
        {
            System.out.println("The lever is pressed while Suriel is on the X");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void play()
    {
        while (!isGameOver())
        {
            //System.out.println("stairs = " + goStairs + " afhin " + aftHin + " chanCount " + chanCount + " nursCount "+ nursCount);
            grid.pause(100);
            handleKeyPress();
            grid.allCutScenes();
            
            if(bgInt == -1)
            {
                menuScreen();
            }
            else if(bgInt == 0)
            {
                decideGender();
            }
            else if(bgInt==18)
            {
                setupCredits();
            }
            else
            {
                
                showBoard();
                displayHearts();
                //System.out.println(enemies.get(0));
                if (msElapsed % 300 == 0)
                {
                    if(enableBoss)
                    {
                        if(grid.getCutscene())
                            suri = suriStand;
                        else
                            suri = suriWalk;
                        goCrazy();
                    }
                    else
                        suri = suriStand;
                    //if(bgInt==1) //cutscene with suriel
                    //scrollup method for E's off the roof maybe?
                    //scrollLeft();
                    //populateRightEdge();
                    if(bgInt !=0)
                    {
                        if(grid.getCutscene()==false)
                            makeEnemiesAct();
                    }
                }
                updateTitle();
                msElapsed += 100;
            }
        }
    }

    //checks if the row/col is valid
    public boolean isValid(int row, int col)
    {
        if(row<grid.getNumRows() && row>=0 && col<grid.getNumCols() && col>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //is a lever
    public boolean isLever(Location loc)
    {
        if(grid.getImage(loc)!=null && grid.getImage(loc).indexOf("lever")!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //checks if there is a wall
    public boolean isWall(Location loc)
    {
        if(grid.getImage(loc)==(null)) //if there is nothing there
        {
            return false;
        }
        /*else if(grid.getImage(loc).equals(tw) || grid.getImage(loc).equals(bw) || grid.getImage(loc).equals(lw) || grid.getImage(loc).equals(rw) || grid.getImage(loc).equals(cw))
        {
            return true;
        }*/
        else if(grid.getImage(loc).indexOf("tab")!=-1 || grid.getImage(loc).indexOf("ball")!=-1 || grid.getImage(loc).indexOf("nothing")!=-1 || grid.getImage(loc).indexOf("lady")!=-1 || grid.getImage(loc).indexOf("skate")!=-1 || grid.getImage(loc).indexOf("money")!=-1 || grid.getImage(loc).indexOf("kim")!=-1 || grid.getImage(loc).indexOf("teddy")!=-1 || grid.getImage(loc).indexOf("bed")!=-1 || grid.getImage(loc).indexOf("robo")!=-1 || grid.getImage(loc).indexOf("nurse")!=-1 || grid.getImage(loc).indexOf("bat")!=-1 || grid.getImage(loc).indexOf("suri")!=-1 || grid.getImage(loc).indexOf("desk")!=-1 || grid.getImage(loc).indexOf("hole")!=-1 || grid.getImage(loc).indexOf("chair")!=-1 || grid.getImage(loc).indexOf("chan")!=-1 || grid.getImage(loc).indexOf("rock")!=-1 || grid.getImage(loc).indexOf("fire")!=-1 || grid.getImage(loc).indexOf("wall")!=-1 || grid.getImage(loc).indexOf("stairs")!=-1 || isLever(loc)==true) //if it's a wall or stairs
        {
            //if img is stairs and to the left of it is the user
            if(grid.getImage(loc).indexOf("stairs")!=-1 &&  grid.getImage(new Location(loc.getRow(), loc.getCol()-1))!=null && grid.getImage(new Location(loc.getRow(), loc.getCol()-1)).indexOf(user)!=-1)
            {
                if(goStairs)
                    nextLvl();
            }

            //if img is lever and to the right of it is the user
            if(grid.getImage(loc).indexOf("lever")!=-1 && grid.getImage(new Location(loc.getRow(), loc.getCol()+1))!=null && grid.getImage(new Location(loc.getRow(), loc.getCol()-1)).indexOf(user)!=-1)
            {
                //pull lever here
                pullLever();
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //what happens when the lever is pulled
    public void pullLever()
    {
        for(int r=0;r<bg.length;r++)
        {
            for(int c=0;c<bg[0].length;c++)
            {
                //System.out.println(bg[r][c]);
                Location curr = new Location(r, c);
                if(bg[r][c]!=null && bg[r][c].equals(fire))
                {
                    int posOfP = noFi.indexOf('.');
                    String temp = noFi.substring(0,posOfP)+bgInt+".gif";
                    grid.setImage(curr, temp);
                    bg[r][c] = temp;
                }
                else if(bg[r][c]!=null && bg[r][c].equals(rock))
                {
                    int posOfP = noRo.indexOf('.');
                    String temp = noRo.substring(0,posOfP)+bgInt+".gif";
                    grid.setImage(curr, temp);
                    bg[r][c] = temp;
                }
                else if(bg[r][c]!=null && bg[r][c].equals(bats))
                {
                    String temp = noBa;
                    grid.setImage(curr, temp);
                    bg[r][c] = temp;
                }
                else if(bg[r][c]!=null && bg[r][c].equals(noBa))
                {
                    String temp = bats;
                    grid.setImage(curr, temp);
                    bg[r][c] = temp;
                }
                if(bgInt==17 && onX()==true) //if boss battle and suriel is on x
                {
                    grid.setCutscene(true); //enable cutscene mode!
                }
                /*else if(bg[r][c]!=null && bg[r][c].equals(noFire))
                {
                    grid.setImage(curr, null);
                    bg[r][c]=null;
                    grid.setImage(curr, fire);
                    bg[r][c]=fire;
                }*/
            }
        }
        if(!isMute)
            leverSound.play();
        //yayTada.play();
    }
    
    public void nextLvl()
    {
        if(bgInt==0)
            setupLevel1();
        else if(bgInt==1)
            setupLevel2();
        else if(bgInt==2)
            setupLevel3();
        else if(bgInt==3)
            setupLevel4();
        else if(bgInt==4)
            setupLevel5();
        else if(bgInt==5)
            setupLevel6();
        else if(bgInt==6)
            setupLevel7();
        else if(bgInt==7)
            setupLevel8();
        else if(bgInt==8)
            setupLevel9();
        else if(bgInt==9)
            setupLevel10();
        else if(bgInt==10)
            setupLevel11();
        else if(bgInt==11)
            setupLevel12();
        else if(bgInt==12)
            setupLevel13();
        else if(bgInt==13)
            setupLevel14();
        else if(bgInt==14)
            setupLevel15();
        else if(bgInt==15)
            setupLevel16();
        else if(bgInt==16)
            setupLevel17();
        else if(bgInt==17)
            setupCredits();
        else if(bgInt==18)
        {
            setupCredits();
        }
    }
    
    public void handleKeyPress()
    {
        System.out.println("holdctrl is "+grid.getHoldCtrl()+" holdz is "+grid.getHoldZ());
        

        int key = grid.checkLastKeyPressed();
        int keyR = grid.getKeyReleased();
        
        System.out.println("KEY IS "+key);
        //System.out.println(userRow);
        String temp;
        
        //user gender stuff
        if(isGirl == false) //if boy
        {
            temp = "userB.png";
            //uw = "userBW.gif";
        }
        else //if girl
        {
            temp = "userG.png";
            //uw = "userGW.gif";
        }
        
        //MENU SCREEN
        if(bgInt == -1)
        {
            if(menNum==0) //if on play
            {
                if(key==40) //down
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 1; //now on controls
                }
                if(key==38) //up
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 3;
                }
                if(key==10 || key==32) //enter or space
                {
                    decideGender();
                }
            }
            else if(menNum==1) //if on controls
            {
                if(key==40) //down
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 2; //now on audio
                }
                if(key==38) //up
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 0;
                }
                if(key==10  || key==32) //enter
                {
                    menNum = 6;
                }
            }
            else if(menNum==2) //if on audio
            {
                if(key==40) //down
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 3;
                }
                if(key==38) //up
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 1;
                }
                if(key==10 || key==32) //enter
                {
                    menNum = 4;
                }
            }
            else if(menNum==3) //if on gallery
            {
                if(key==40) //down
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 0;
                }
                if(key==38) //up
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 2;
                }
                if(key==10 || key==32) //enter
                {
                    menNum = 11;
                }
            }
            else if(menNum==4) //if on mute
            {
                if(key==10 || key==32) //enter
                {
                    isMute = true;
                    menNum = 2;
                }
                if(key==39) //right
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 5;
                }
            }
            else if(menNum==5) //if on unmute
            {
                if(key==10 || key==32) //enter
                {
                    isMute = false;
                    menNum = 2;
                }          
                if(key==37) //left
                {
                    if(!isMute)
                        menScr.play();
                    menNum = 4;
                }
            }
            else if(menNum==6)
            {
                if(key==32) //space
                {
                    menNum = 7;
                }
                if(key==27) //esc
                {
                    menNum = 1;
                }
            }
            else if(menNum==7)
            {
                if(key==32)
                {
                    menNum = 8;
                }
                if(key==27)
                {
                    menNum = 1;
                }
            }
            else if(menNum==8)
            {
                if(key==32)
                {
                    menNum = 9;
                }
                if(key==27)
                {
                    menNum = 1;
                }
            }
            else if(menNum==9)
            {
                if(key==32)
                {
                    menNum = 10;
                }
                if(key==27)
                {
                    menNum = 1;
                }
            }
            else if(menNum==10)
            {
                if(key==27)
                {
                    menNum = 1;
                }
                if(key==32)
                {
                    menNum = 1;
                }
            }
            else if(menNum==11)
            {
                if(key==27)
                {
                    menNum = 1;
                }
                if(key==32)
                {
                    menNum = 1;
                }
            }
        }
        
        //deciding gender
        else if(bgInt == 0)
        {
            
            if(key==49 || key==37) //if 1
            {
                if(!isMute)
                    menScr.play();
                isGirl = false;
            }
            if(key==50 || key==39) //if 2
            {
                if(!isMute)
                    menScr.play();
                isGirl = true;
            }
            if(key==10) //enter
            {
                setupLevel1();
                grid.setBlinkRec(false);
            }
            //user gender stuff
            if(isGirl == false) //if boy
            {
                user = "userB.png";
                walk = "userBW.gif";
                tempUser = "userB.png";
            }
            else //if girl
            {
                user = "userG.png";
                walk = "userGW.gif";
                tempUser = "userG.png";
            }
        }
        
        //17 and 50
        else if(bgInt==17 && grid.getHoldCtrl()==true && grid.getHoldZ()==true)
        {
            grid.setImage(new Location(userRow,userCol),null);
            grid.setCutscene(false);
            bgInt=18;
        }
        
        //LEVELS
        else
        {
            if(!grid.getCutscene())
                userKeysDuringLevels(key,temp);
            else
            {               
                if(grid.getImage(new Location(userRow,userCol))!=null && grid.getImage(new Location(userRow,userCol)).equals(walk))
                {
                    grid.setImage(new Location(userRow,userCol), user); 
                    bg[userRow][userCol] = tempUser;
                }
                if(key==32) //space
                {
                    //let's say that the first set of Cutscenes are from 0 to 4 inclusive 
                    if(grid.getCurrCutScene()<10 && bgInt==1)
                    {
                        grid.nextCutscene();
                        if(grid.getCurrCutScene()==4)
                        {
                            if(!isMute)
                                echeer.loop();
                            //makes the devil E's shake
                            for(int r=0;r<bg.length;r++)
                            {
                                for(int c=0;c<bg[0].length;c++)
                                {
                                    if(bg[r][c]!=null)
                                    {
                                        if(bg[r][c].equals(devE))
                                        {
                                            bg[r][c] = shDE;
                                        }
                                        else if(bg[r][c].equals(sleE))
                                        {
                                            bg[r][c] = sSLE;
                                        }
                                        else if(bg[r][c].equals(bbbE))
                                        {
                                            bg[r][c] = sBBE;
                                        }
                                        else if(bg[r][c].equals(bbgE))
                                        {
                                            bg[r][c] = sBGE;
                                        }
                                    }
                                }
                            }
                        }
                        if(grid.getCurrCutScene()==5)
                        {
                            echeer.stop();
                            //turns devil E's back to normal
                            for(int r=0;r<bg.length;r++)
                            {
                                for(int c=0;c<bg[0].length;c++)
                                {
                                    if(bg[r][c]!=null)
                                    {
                                        if(bg[r][c].equals(shDE))
                                        {
                                            bg[r][c] = devE;
                                        }
                                        else if(bg[r][c].equals(sSLE))
                                        {
                                            bg[r][c] = sleE;
                                        }
                                        else if(bg[r][c].equals(sBBE))
                                        {
                                            bg[r][c] = bbbE;
                                        }
                                        else if(bg[r][c].equals(sBGE))
                                        {
                                            bg[r][c] = bbgE;
                                        }
                                    }
                                }
                            }
                        }
                        if(grid.getCurrCutScene()>9)
                        {
                            if(!isMute)
                            {
                                sspeech.stop();
                                s1.loop();
                            }
                            //black screen
                            grid.setBlackScreen(true);
                        }
                    }
                    else if(grid.getCurrCutScene()<14 && bgInt==2)
                    {
                        if(grid.getCurrCutScene()==13)
                        {
                            if(!isMute)
                            {
                                hint.play();
                            }
                        }
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<18 && bgInt==3)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<21 && bgInt==4)
                    {
                        hint.stop();
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<22 && bgInt==5)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<23 && bgInt==6 && aftHin==false)
                    {
                        grid.nextCutscene();
                        aftHin = true;
                        //goStairs = true;
                    }
                    else if(grid.getCurrCutScene()<38 && bgInt==6 && aftHin==true)
                    {
                        goStairs = true;
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<39 && bgInt==7)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<40 && bgInt==8)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<45 && bgInt==9) //nurse
                    {
                        if(grid.getCurrCutScene()==43)
                        {
                            health = 4;
                        }
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<46 && bgInt==10)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<47 && bgInt==11)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<52 && bgInt==12)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<53 && bgInt==13)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<54 && bgInt==14)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<62 && bgInt==15)
                    {
                        if(grid.getCurrCutScene()==60)
                            health = 4;
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<63 && bgInt==16)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<64 && bgInt==17 && surTalk==false)
                    {
                        grid.nextCutscene();
                    }
                    else if(grid.getCurrCutScene()<97 && bgInt==17 && surTalk==true)
                    {
                        songCount++;
                        if(!isMute)
                        {
                            if(songCount==1)
                            {
                                s10.stop();
                                s11.loop();
                            }
                        }
                        surStill=true;
                        grid.nextCutscene();
                        if(grid.getCurrCutScene()==97)
                        {
                            if(!isMute)
                                hint.play();
                        }
                        //17 ctrl 90 z            
                        
                    }
                    else
                    {
                        if(bgInt==1)
                        {
                            grid.setBlackScreen(false);
                            grid.setCutscene(false);
                            setupLevel2();
                        }
                        else if(bgInt>=2 && bgInt<=17)
                        {
                            grid.setCutscene(false);
                            if(bgInt==6)
                            {
                                aftHin = true;
                                if(goStairs == true)
                                    chanCount = 1;
                            }
                            if(bgInt==9)
                            {
                                goStairs = true;
                                nursCount = 1;
                            }
                            if(bgInt==12)
                            {
                                goStairs = true;
                                kimCount = 1;
                            }
                            if(bgInt==15)
                            {
                                goStairs = true;
                                lulaCount = 1;
                            }
                            if(bgInt==17)
                            {
                                surTalk = true;
                                if(surTalk==true)
                                {
                                    grid.nextCutscene();
                                    s11.stop();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void userKeysDuringLevels(int key, String temp)
    {
       
        if(key==38 && userRow!=0) //if going up
        {
            Location above = new Location(userRow-1,userCol);
            String img = grid.getImage(above);
            if(img!=null && img.indexOf("E")!=-1)
            {
                if(!isMute)
                    ouch.play();
                health--;
            }
            else if(!isWall(above))
            {
                user = walk;
                //move up
                grid.setImage(new Location(userRow,userCol), null); //removes the first image
                bg[userRow][userCol] = null;
                userRow--;
                handleCollision(new Location(userRow, userCol));
                grid.setImage(new Location(userRow,userCol), user); //adds the next image in the next position
                bg[userRow][userCol] = user;
            }
        }
        if(key==40 && userRow!=grid.getNumRows()-1) //if going down
        {
            Location below = new Location(userRow+1, userCol);
            String img = grid.getImage(below);
            if(img!=null && img.indexOf("E")!=-1)
            {
                if(!isMute)
                    ouch.play();
                health--;
            }
            else if(!isWall(below))
            {
                user = walk;
                grid.setImage(new Location(userRow,userCol), null); //removes the first image
                bg[userRow][userCol] = null;
                userRow++;
                handleCollision(new Location(userRow, userCol+1)); //changed 1 to userCol+1 might be an issue later
                grid.setImage(new Location(userRow,userCol), user); //adds the next image in the next position
                bg[userRow][userCol] = user;
            }
        }
        //right
        if(key==39 && userCol!=grid.getNumCols()-1) //if going right
        {
            Location right = new Location(userRow, userCol+1);
            String img = grid.getImage(right);
            if(img!=null && img.indexOf("E")!=-1)
            {
                if(!isMute)
                    ouch.play();
                health--;
            }
            else if(!isWall(right))
            {
                user = walk;
                grid.setImage(new Location(userRow,userCol), null); //removes the first image
                bg[userRow][userCol] = null;
                userCol++;
                grid.setImage(new Location(userRow,userCol), user); //adds the next image in the next position
                bg[userRow][userCol] = user;
            }
        }
        //left
        if(key==37 && userCol!=0)
        {
            Location left = new Location(userRow, userCol-1);
            String img = grid.getImage(left);
            if(img!=null && img.indexOf("E")!=-1)
            {
                if(!isMute)
                    ouch.play();
                health--;
            }
            else if(!isWall(left))
            {
                user = walk;
                grid.setImage(new Location(userRow,userCol), null); //removes the first image
                bg[userRow][userCol] = null;
                userCol--;
                grid.setImage(new Location(userRow,userCol), user); //adds the next image in the next position
                bg[userRow][userCol] = user;     
            }
        }
        if(key==-1) //if nothing is pressed
        {
            user = temp;
            grid.setImage(new Location(userRow,userCol), null); //removes the first image
            bg[userRow][userCol] = null;
            grid.setImage(new Location(userRow,userCol), user);
            bg[userRow][userCol] = user;     
        }
        if(key==32) //space
        {
            Location left = new Location(userRow, userCol-1);
            if(isLever(left) && grid.getImage(left).indexOf("pull")==-1) //not pull but lever
            {
                grid.setImage(left, "leverpull.png");
                bg[userRow][userCol-1] = "leverpull.png";
                pullLever();
            }
            else if(isLever(left) && grid.getImage(left).indexOf("pull")!=-1) //pull lever
            {
                grid.setImage(new Location(userRow,userCol-1), "lever.png");
                bg[userRow][userCol-1] = "lever.png";
                pullLever();
            }
            //if chan
            else if(grid.getImage(new Location(userRow, userCol))!=null && grid.getImage(new Location(userRow, userCol+1))!=null && grid.getImage(new Location(userRow, userCol)).equals(user) && grid.getImage(new Location(userRow, userCol+1)).equals(chan))
            {
                if(chanCount != 1 && bgInt==6)
                {
                    grid.nextCutscene();
                    grid.setCutscene(true);
                }
            }
            //if nurse
            else if(grid.getImage(new Location(userRow, userCol))!=null && grid.getImage(new Location(userRow, userCol+1))!=null && grid.getImage(new Location(userRow, userCol)).equals(user) && grid.getImage(new Location(userRow, userCol+1)).equals(nurs))
            {
                if(nursCount != 1 && bgInt==9)
                {
                    grid.nextCutscene();
                    grid.setCutscene(true);
                }
            }
            //if kim
            else if(grid.getImage(new Location(userRow, userCol))!=null && grid.getImage(new Location(userRow, userCol+1))!=null && grid.getImage(new Location(userRow, userCol)).equals(user) && grid.getImage(new Location(userRow, userCol+1)).equals(kimm))
            {
                if(kimCount != 1 && bgInt==12)
                {
                    grid.nextCutscene();
                    grid.setCutscene(true);
                }
            }
            //if kim
            else if(grid.getImage(new Location(userRow, userCol))!=null && grid.getImage(new Location(userRow, userCol+1))!=null && grid.getImage(new Location(userRow, userCol)).equals(user) && grid.getImage(new Location(userRow, userCol+1)).equals(luLa))
            {
                if(lulaCount != 1 && bgInt==15)
                {
                    grid.nextCutscene();
                    grid.setCutscene(true);
                }
            }
            

        }
    }
    
    public void makeEnemiesAct()
    {
        for(EvilE E: enemies)
        {
            E.act();
        }
    }

    public void showBoard()
    {
        if(bgInt != 0 || bgInt != -1)
        {
            for(int r=0; r < bg.length; r++)
            {
                for(int c = 0; c < bg[0].length; c++)
                {
                    grid.setImage(new Location(r, c), bg[r][c]);
                }
            }
        }
    }
    
    //when the user and E collides
    public void handleCollision(Location loc)
    {
        String img = grid.getImage(loc); //current img
        if(img==null)
        {
            return;
        }
        else if(img.equals("get.gif"))
        {
            timesGet++;
        }
        else
        {
            timesAvoid++;
        }
        if(img.indexOf("E")==-1)//if the image is not the evil E then i set it to null
        {
            grid.setImage(loc, null);
        }
    }

    public int getScore()
    {
        int output = timesGet-timesAvoid;
        if(output<0) //if neg
            output = 0;
        //System.out.println("HEHEHEHEHEHHEEHHEE " + output);
        return output;
    }

    public void updateTitle()
    {
        grid.setTitle("Evil E's:  " + getScore());
    }

    public boolean isGameOver()
    {
        if(health==0)
        {
            //do gameover screen
            //loserScreen();
            if(!isMute)
            {
                introSong.stop();
                bg1.stop();
                gameOver.play();
            }
            
            grid.setBackground("gameover.png");
            for(int r=0;r<bg.length;r++)
            {
                for(int c=0;c<bg[0].length;c++)
                {
                    grid.setImage(new Location(r, c), null);
                    bg[r][c] = null;
                }
            }
            return true;
        }
        return false;
    }

    //this method gets suriel's location
    public Location getSurLoc()
    {
        for(int r=0;r<bg.length;r++)
        {
            for(int c=0;c<bg[0].length;c++)
            {
                if(grid.getImage(new Location(r,c)).equals(suri)) //if thats suriel
                {
                    return new Location(r,c);
                }
            }
        }
        return null; //suriel ain't there
    }
    
    //this method moves suriel to the left
    public void surielLeft()
    {
        Location curr = new Location(surRow, surCol);
        Location left = new Location(surRow, surCol-1);
        if(grid.getImage(left)!=null && (grid.getImage(left).indexOf(user)!=-1 || grid.getImage(left).indexOf("E")!=-1))
        {
            if(grid.getImage(left).indexOf(user)!=-1)
                health--;
            //surielRight(); //bounce off!
        }
        else if(!isWall(left))
        {
            //bye bye suriel
            grid.setImage(curr, null);
            bg[surRow][surCol] = null;
            surCol--;
            
            //welcome back suriel
            grid.setImage(curr, suri);
            bg[surRow][surCol] = suri;
        }
    }
    
    //suriel move to the right
    public void surielRight()
    {
        Location curr = new Location(surRow, surCol);
        Location right = new Location(surRow, surCol+1);
        if(grid.getImage(right)!=null && (grid.getImage(right).indexOf(user)!=-1 || grid.getImage(right).indexOf("E")!=-1))
        {
            if(grid.getImage(right).indexOf(user)!=-1)
                health--;
            //surielLeft(); //bounce off!
        }
        else if(!isWall(right))
        {
            //bye bye suriel
            grid.setImage(curr, null);
            bg[surRow][surCol] = null;
            surCol++;
            
            //welcome back suriel
            grid.setImage(curr, suri);
            bg[surRow][surCol] = suri;
        } 
    }
    
    //suriel move to the up
    public void surielUp()
    {
        Location curr = new Location(surRow, surCol);
        Location up = new Location(surRow-1, surCol);
        if(grid.getImage(up)!=null && (grid.getImage(up).indexOf(user)!=-1 || grid.getImage(up).indexOf("E")!=-1))
        {
            if(grid.getImage(up).indexOf(user)!=-1)
                health--;
            //surielDown(); //bounce off!
        }
        else if(!isWall(up))
        {
            //bye bye suriel
            grid.setImage(curr, null);
            bg[surRow][surCol] = null;
            surRow--;
            
            //welcome back suriel
            grid.setImage(curr, suri);
            bg[surRow][surCol] = suri;
        } 
    }
    
    //suriel move to the down
    public void surielDown()
    {
        Location curr = new Location(surRow, surCol);
        Location down = new Location(surRow+1, surCol);
        if(grid.getImage(down)!=null && (grid.getImage(down).indexOf(user)!=-1 || grid.getImage(down).indexOf("E")!=-1))
        {
            if(grid.getImage(down).indexOf(user)!=-1)
                health--;
            //surielUp(); //bounce off!
        }
        else if(!isWall(down))
        {
            //bye bye suriel
            grid.setImage(curr, null);
            bg[surRow][surCol] = null;
            surRow++;
            
            //welcome back suriel
            grid.setImage(curr, suri);
            bg[surRow][surCol] = suri;
        } 
    }
    
    //gocrazy
    public void goCrazy()
    {
        if(!surStill)
        {
            int rand = (int)(Math.random()*4); //0 to 3
            if(rand==0)
                surielLeft();
            else if(rand==1)
                surielRight();
            else if(rand==2)
                surielUp();
            else
                surielDown();
        }
    }
    
    public static void test()
    {
        Game game = new Game();
        game.play();
    }

    public static void main(String[] args)
    {
        Game.test();
        //Game g = new Game();
        //g.populateRightEdge();
    }
}