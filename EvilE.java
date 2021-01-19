import java.applet.*;

public class EvilE
{
    private int row, col;
    private String imageName;
    private String whatShouldIDo;   
    private String currDir;
    private AudioClip cry;
    
    public EvilE(int r, int c, String iN, String wsid, String cD)
    {
        row = r;
        col = c;
        imageName = iN;
        whatShouldIDo = wsid;
        currDir = cD;
        cry = Applet.newAudioClip(this.getClass().getResource("babySE.wav"));
    }
    
    public String toString()
    {
        return "Evil E at " + row + ", " + col;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public String getImageName()
    {
        return imageName;
    }
    
    public Location getLocation()
    {
        return new Location(row, col);
    }
    
    public String getWDIS()
    {
        return whatShouldIDo;
    }
            
    public void act()
    {
        String[][] world = Game.bg;
        
        if(whatShouldIDo.equals("upAndDown"))
        {
            //if current direction is down
            if(currDir.equals("down"))
            {
                //nextImage is where the E wants to go next
                //in this case, it's one below the user
                String nextImage = world[row+1][col];
                
                //if the nextImage has nothing there, the E moves there
                //if the nextImage has something there, the E moves the opposite way
                if(nextImage==null || nextImage.indexOf("out")!=-1)
                {
                    world[row][col] = null;
                    row++;
                    world[row][col] = imageName;
                }
                else
                {
                    handleCol(nextImage);
                    currDir="up";
                }
            }
            //if current direction is up
            else if(currDir.equals("up"))
            {
                String nextImage = world[row-1][col];
                if(nextImage==null || nextImage.indexOf("out")!=-1)
                {
                    
                    world[row][col] = null;
                    row--;
                    world[row][col] = imageName;
                }
                else
                {
                    handleCol(nextImage);
                    currDir="down";
                }
            }
        }
        
        //go left to right
        else if(whatShouldIDo.equals("leftAndRight"))
        {
            //can only go left or right
            if(currDir.equals("left"))
            {
                String nextImage = world[row][col-1];
                if(nextImage==null || nextImage.indexOf("out")!=-1)
                {
                    world[row][col] = null;
                    col--;
                    world[row][col] = imageName;
                }
                else
                {
                    handleCol(nextImage);
                    currDir="right";
                }
            }
            else if(currDir.equals("right"))
            {
                String nextImage = world[row][col+1];
                if(nextImage==null || nextImage.indexOf("out")!=-1)
                {
                    world[row][col] = null;
                    col++;
                    world[row][col] = imageName;
                }
                else
                {
                    handleCol(nextImage);
                    currDir="left";
                }
            }
        }
        else if((whatShouldIDo.equals("diagonal")))
        {
            //going diagonal upwards right
            if(currDir.equals("diagUpR"))
            {
                String nextImage = world[row - 1][col + 1];
                if(nextImage == null)
                {
                    world[row][col] = null;
                    row--;
                    col++;
                    world[row][col] = imageName;
                }
                else
                {
                    currDir = "diagDownL";
                }
            }
            //going diagonal downwards left
            else if(currDir.equals("diagDownL"))
            {
                String nextImage = world[row + 1][col - 1];
                if(nextImage == null)
                {
                    world[row][col] = null;
                    row++;
                    col--;
                    world[row][col] = imageName;
                }
                else
                {
                    currDir = "diagUpR";
                }
            }
            //going diagonal upwards left
            else if(currDir.equals("diagUpL"))
            {
                String nextImage = world[row - 1][col - 1];
                if(nextImage == null)
                {
                    world[row][col] = null;
                    row--;
                    col--;
                    world[row][col] = imageName;
                }
                else
                {
                    currDir = "diagDownR";
                }
            }
            //going diagonal downwards right
            else if(currDir.equals("diagDownR"))
            {
                String nextImage = world[row + 1][col + 1];
                if(nextImage == null)
                {
                    world[row][col] = null;
                    row++;
                    col++;
                    world[row][col] = imageName;
                }
                else
                {
                    currDir = "diagUpL";
                }
            }
        }
        else if(whatShouldIDo.equals("nothing"))
        {
            if(currDir.equals("nothing"))
            {
                world[row][col] = imageName;
            }
        }
    }
    public void handleCol(String img)
    {
        if(img.indexOf("user")!=-1)
        {
            if(!Game.isMute && (imageName.equals("babyGE.png") || imageName.equals("babyBE.png")))
                cry.play();
            Game.health--;
        }
    }
}