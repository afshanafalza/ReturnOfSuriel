import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class Grid extends JComponent implements KeyListener, MouseListener
{

    private Cell[][] cells;
    private JFrame frame;
    private int lastKeyPressed, lastKeyReleased;
    private Location lastLocationClicked;
    private Color lineColor;
    private BufferedImage backgroundImage;
    private boolean bgSet = false;
    private boolean blinkRec;
    private boolean isGirl;
    private Game g;
    private boolean cutscene;
    private String[] cutsceneImgs;
    private ImageIcon[] cutsceneIcons;
    private int currCS;
    private boolean blackScreen;
    private boolean holdCtrl;
    private boolean holdZ;
    
    public Grid(int numRows, int numCols)
    {

        init(numRows, numCols);
        blinkRec = false;
        cutscene = false;
        currCS = 0;

        //@MS UI GOTHIC 29 for name
        //malgun gothic 23 for dialogue
        cutsceneImgs = new String[98];//must match and must be the number of images
        cutsceneIcons = new ImageIcon[98];
        
        //setupImageIcons();
    }

    public void allCutScenes()
    {
        //cutscene #1
        //SURIEL: Greetings, my beautiful little E’s!
        cutsceneImgs[0] = "dialogue1s.gif";

        //SURIEL: The day is finally here... I hope you're all ready!
        cutsceneImgs[1] = "dialogue2s.gif";
        
        //DEVIL E: Yes we are!
        cutsceneImgs[2] = "dialogue1d.gif";
        
        //SURIEL: I can't hear you!
        cutsceneImgs[3] = "dialogue3s.gif";
        
        //DEVIL E: Yes we are! (but crazy)
        cutsceneImgs[4] = "dialogue2d.gif";

        //SURIEL: Very good, now take your positions...
        cutsceneImgs[5] = "dialogue4s.gif";
        
        //SURIEL: On 3...
        cutsceneImgs[6] = "dialogue5s.gif";
        
        //SURIEL: On 3...
        cutsceneImgs[7] = "dialogue6s.gif";
        
        //SURIEL: On 3...
        cutsceneImgs[8] = "dialogue7s.gif";
        
        //SURIEL: On 3...
        cutsceneImgs[9] = "dialogue8s.gif";

        //user
        if(isGirl==false)
        {
            //cutscene #2
            cutsceneImgs[10] = "dialogue1b.gif";
            cutsceneImgs[11] = "dialogue2b.gif";
            cutsceneImgs[12] = "dialogue3b.gif";
            cutsceneImgs[13] = "dialogue4b.gif";
            cutsceneImgs[14] = "dialogue1h.gif";

            //cutscene #3
            cutsceneImgs[15] = "dialogue5b.gif";
            cutsceneImgs[16] = "dialogue6b.gif";
            cutsceneImgs[17] = "dialogue7b.gif";
            cutsceneImgs[18] = "dialogue8b.gif";
            
            //cutscene #4
            cutsceneImgs[19] = "dialogue9b.gif";
            cutsceneImgs[20] = "dialogue10b.gif";
            cutsceneImgs[21] = "dialogue11b.gif";
            
            //cutscene #5
            cutsceneImgs[22] = "dialogue12b.gif";
            
            //cutscene #6
            //before hint
            cutsceneImgs[23] = "dialogue2h.gif";
            
            //after hint
            cutsceneImgs[24] = "dialogue13b.gif";
            cutsceneImgs[25] = "dialoguePhone.gif";
            cutsceneImgs[26] = "dialogue14b.gif";
            cutsceneImgs[27] = "dialogue1c.gif";
            cutsceneImgs[28] = "dialogue15b.gif";
            cutsceneImgs[29] = "dialogue2c.gif";
            cutsceneImgs[30] = "dialogue16b.gif";
            cutsceneImgs[31] = "dialogue3c.gif";
            cutsceneImgs[32] = "dialogue17b.gif";
            cutsceneImgs[33] = "dialogue4c.gif";
            cutsceneImgs[34] = "dialogue5c.gif";
            cutsceneImgs[35] = "dialogue6c.gif";
            cutsceneImgs[36] = "dialogue18b.gif";
            cutsceneImgs[37] = "dialogue7c.gif";
            cutsceneImgs[38] = "dialogue19b.gif";
            
            //cutscene #7
            cutsceneImgs[39] = "dialogue20b.gif";
            
            //cutscene #8
            cutsceneImgs[40] = "dialogue21b.gif";
            
            //cutscene #9
            //nurse
            cutsceneImgs[41] = "dialogue1n.gif";
            cutsceneImgs[42] = "dialogue22b.gif";
            cutsceneImgs[43] = "dialogue2n.gif";
            cutsceneImgs[44] = "dialogueHP.gif";
            cutsceneImgs[45] = "dialogue3n.gif";
            
            //cutscene #10
            cutsceneImgs[46] = "dialogue23b.gif";
            
            //cutscene #11
            cutsceneImgs[47] = "dialogue24b.gif";
            
            //cutscene #12
            cutsceneImgs[48] = "dialoguek1.gif";
            cutsceneImgs[49] = "dialogue25b.gif";
            cutsceneImgs[50] = "dialoguek2.gif";
            cutsceneImgs[51] = "dialogueHALL.gif";
            cutsceneImgs[52] = "dialogue26b.gif";
            
            //cutscene #13
            cutsceneImgs[53] = "dialogue27b.gif";
            
            //cutscene #14
            cutsceneImgs[54] = "dialogue28b.gif";
            
            //cutscene #15
            cutsceneImgs[55] = "dialogue1L.gif";
            cutsceneImgs[56] = "dialogue29b.gif";
            cutsceneImgs[57] = "dialogue2L.gif";
            cutsceneImgs[58] = "dialogue30b.gif";
            cutsceneImgs[59] = "dialogue3L.gif";
            cutsceneImgs[60] = "dialogue31b.gif";
            cutsceneImgs[61] = "dialogueSL.gif";
            cutsceneImgs[62] = "dialogue4L.gif";
            
            //cutscene #16
            cutsceneImgs[63] = "dialogue32b.gif";
            
            //cutscene #17
            //before battle
            cutsceneImgs[64] = "d1.gif";
            cutsceneImgs[65] = "d2b.gif";
            cutsceneImgs[66] = "d3.gif";
            cutsceneImgs[67] = "d4b.gif";
            cutsceneImgs[68] = "d5.gif";
            cutsceneImgs[69] = "d6b.gif";
            cutsceneImgs[70] = "d7b.gif";
            cutsceneImgs[71] = "d8.gif";
            cutsceneImgs[72] = "d9.gif";
            cutsceneImgs[73] = "d10.gif";
            cutsceneImgs[74] = "d11b.gif";
            cutsceneImgs[75] = "d12.gif";
            cutsceneImgs[76] = "d13b.gif";
            cutsceneImgs[77] = "d14.png";
            cutsceneImgs[78] = "d15b.gif";
            cutsceneImgs[79] = "d16.gif";
            cutsceneImgs[80] = "d17b.gif";
            cutsceneImgs[81] = "d18.gif";
            cutsceneImgs[82] = "d19b.gif";
            cutsceneImgs[83] = "d20b.gif";
            cutsceneImgs[84] = "d21b.gif";
            cutsceneImgs[85] = "d22.gif";
            cutsceneImgs[86] = "d23b.gif";
            cutsceneImgs[87] = "d24.gif";
            cutsceneImgs[88] = "d25b.gif";
            cutsceneImgs[89] = "d26b.gif";
            cutsceneImgs[90] = "d27.gif";
            cutsceneImgs[91] = "d28.gif";
            cutsceneImgs[92] = "d29b.gif";
            cutsceneImgs[93] = "d30.gif";
            cutsceneImgs[94] = "d31b.gif";
            cutsceneImgs[95] = "d32.gif";
            cutsceneImgs[96] = "d33b.gif";
            cutsceneImgs[97] = "dialogueHintEnd.gif";
            
        }
        else
        {
            //cutscene #2
            cutsceneImgs[10] = "dialogue1g.gif";
            cutsceneImgs[11] = "dialogue2g.gif";
            cutsceneImgs[12] = "dialogue3g.gif";
            cutsceneImgs[13] = "dialogue4g.gif";
            cutsceneImgs[14] = "dialogue1h.gif";

            //cutscene #3
            cutsceneImgs[15] = "dialogue5g.gif";
            cutsceneImgs[16] = "dialogue6g.gif";
            cutsceneImgs[17] = "dialogue7g.gif";
            cutsceneImgs[18] = "dialogue8g.gif";
            
            //cutscene #4
            cutsceneImgs[19] = "dialogue9g.gif";
            cutsceneImgs[20] = "dialogue10g.gif";
            cutsceneImgs[21] = "dialogue11g.gif";
            
            //cutscene #5
            cutsceneImgs[22] = "dialogue12g.gif";
            
            //cutscene #6
            //before hint
            cutsceneImgs[23] = "dialogue2h.gif";
            
            //after hint
            cutsceneImgs[24] = "dialogue13g.gif";
            cutsceneImgs[25] = "dialoguePhone.gif";
            cutsceneImgs[26] = "dialogue14g.gif";
            cutsceneImgs[27] = "dialogue1c.gif";
            cutsceneImgs[28] = "dialogue15g.gif";
            cutsceneImgs[29] = "dialogue2c.gif";
            cutsceneImgs[30] = "dialogue16g.gif";
            cutsceneImgs[31] = "dialogue3c.gif";
            cutsceneImgs[32] = "dialogue17g.gif";
            cutsceneImgs[33] = "dialogue4c.gif";
            cutsceneImgs[34] = "dialogue5c.gif";
            cutsceneImgs[35] = "dialogue6c.gif";
            cutsceneImgs[36] = "dialogue18g.gif";
            cutsceneImgs[37] = "dialogue7c.gif";
            cutsceneImgs[38] = "dialogue19g.gif";
            
            //cutscene #7
            cutsceneImgs[39] = "dialogue20g.gif";
            
            //cutscene #8
            cutsceneImgs[40] = "dialogue21g.gif";

            //cutscene #9
            //nurse
            cutsceneImgs[41] = "dialogue1n.gif";
            cutsceneImgs[42] = "dialogue22g.gif";
            cutsceneImgs[43] = "dialogue2n.gif";
            cutsceneImgs[44] = "dialogueHP.gif";
            cutsceneImgs[45] = "dialogue3n.gif";
            
            //cutscene #10
            cutsceneImgs[46] = "dialogue23g.gif";
            
            //cutscene #11
            cutsceneImgs[47] = "dialogue24g.gif";
            
            //cutscene #12
            cutsceneImgs[48] = "dialoguek1.gif";
            cutsceneImgs[49] = "dialogue25g.gif";
            cutsceneImgs[50] = "dialoguek2.gif";
            cutsceneImgs[51] = "dialogueHALL.gif";
            cutsceneImgs[52] = "dialogue26g.gif";
        
            //cutscene #13
            cutsceneImgs[53] = "dialogue27g.gif";
            
            //cutscene #14
            cutsceneImgs[54] = "dialogue28g.gif";

            //cutscene #15
            cutsceneImgs[55] = "dialogue1L.gif";
            cutsceneImgs[56] = "dialogue29g.gif";
            cutsceneImgs[57] = "dialogue2L.gif";
            cutsceneImgs[58] = "dialogue30g.gif";
            cutsceneImgs[59] = "dialogue3L.gif";
            cutsceneImgs[60] = "dialogue31g.gif";
            cutsceneImgs[61] = "dialogueSL.gif";
            cutsceneImgs[62] = "dialogue4L.gif";

            //cutscene #16
            cutsceneImgs[63] = "dialogue32g.gif";
            
            //cutscene #17
            //before battle
            cutsceneImgs[64] = "d1.gif";
            cutsceneImgs[65] = "d2g.gif";
            cutsceneImgs[66] = "d3.gif";
            cutsceneImgs[67] = "d4g.gif";
            cutsceneImgs[68] = "d5.gif";
            cutsceneImgs[69] = "d6g.gif";
            cutsceneImgs[70] = "d7g.gif";
            cutsceneImgs[71] = "d8.gif";
            cutsceneImgs[72] = "d9.gif";
            cutsceneImgs[73] = "d10.gif";
            cutsceneImgs[74] = "d11g.gif";
            cutsceneImgs[75] = "d12.gif";
            cutsceneImgs[76] = "d13g.gif";
            cutsceneImgs[77] = "d14.png";
            cutsceneImgs[78] = "d15g.gif";
            cutsceneImgs[79] = "d16.gif";
            cutsceneImgs[80] = "d17g.gif";
            cutsceneImgs[81] = "d18.gif";
            cutsceneImgs[82] = "d19g.gif";
            cutsceneImgs[83] = "d20g.gif";
            cutsceneImgs[84] = "d21g.gif";
            cutsceneImgs[85] = "d22.gif";
            cutsceneImgs[86] = "d23g.gif";
            cutsceneImgs[87] = "d24.gif";
            cutsceneImgs[88] = "d25g.gif";
            cutsceneImgs[89] = "d26g.gif";
            cutsceneImgs[90] = "d27.gif";
            cutsceneImgs[91] = "d28.gif";
            cutsceneImgs[92] = "d29g.gif";
            cutsceneImgs[93] = "d30.gif";
            cutsceneImgs[94] = "d31g.gif";
            cutsceneImgs[95] = "d32.gif";
            cutsceneImgs[96] = "d33g.gif";
            cutsceneImgs[97] = "dialogueHintEnd.gif";

        }
        
        
    }
    public void setupImageIcons()
    {
        for(int i = 0;i<cutsceneIcons.length;i++)
        {
            ImageIcon d1 = new ImageIcon(Grid.class.getResource(cutsceneImgs[i]));
            cutsceneIcons[i] = d1;
        }
    }
    
    /**
     * added in 5/15/2017 USE THIS CONSTRUCTOR IF YOU WANT A BACKGROUND IMAGE
     * Note: If you use this constructor then you cannot use the method
     * setColor()
     *
     * @param numRows
     * @param numCols
     * @param imageName the background
     */
    public Grid(int numRows, int numCols, String imageName)
    {

        init(numRows, numCols);
        setBackground(imageName);

    }

    public Grid(String imageFileName)
    {
        BufferedImage image = loadImage(imageFileName);
        init(image.getHeight(), image.getWidth());
        showImage(image);
        setTitle(imageFileName);
    }

    /**
     * sets the background to imgName. The img is resized to fit in the grids
     * dimensions. setColor() is disabled
     *
     * @param imgName
     */
    public void setBackground(String imgName)
    {

        backgroundImage = loadImage(imgName);
        bgSet = true;

        repaint();
    }
    
    public void setGender(boolean g)
    {
        isGirl = g;
    }

    public void setBlinkRec(boolean b)
    {
        blinkRec = b;
    }

    public void setBlackScreen(boolean b)
    {
        blackScreen = b;
    }
    
    public void setCutscene(boolean c)
    {
        cutscene = c;
    }
    
    public boolean getCutscene()
    {
        return cutscene;
    }
    public void nextCutscene()
    {
        System.out.println("the current cs is "+getCurrCutScene());
        currCS++;
    }
    public int getCurrCutScene()
    {
        return currCS;
    }
    /**
     * removes the background, allowing setColor to work again.
     */
    public void removeBackground()
    {
        bgSet = false;
    }

    private BufferedImage loadImage(String imageFileName)
    {
        URL url = getClass().getResource(imageFileName);
        if (url == null)
        {
            throw new RuntimeException("cannot find file:  " + imageFileName);
        }
        try
        {
            return ImageIO.read(url);
        } catch (IOException e)
        {
            throw new RuntimeException("unable to read from file:  " + imageFileName);
        }
    }

    public int getNumRows()
    {
        return cells.length;
    }

    public int getNumCols()
    {
        return cells[0].length;
    }

    private void init(int numRows, int numCols)
    {
        lastKeyPressed = -1;
        lastLocationClicked = null;
        lineColor = null;

        cells = new Cell[numRows][numCols];
        for (int row = 0; row < numRows; row++)
        {
            for (int col = 0; col < numCols; col++)
            {
                cells[row][col] = new Cell();
            }
        }

        frame = new JFrame("Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);

        int cellSize = Math.max(Math.min(475 / getNumRows(), 475 / getNumCols()), 1);
        setPreferredSize(new Dimension(3 * cellSize * numCols, 3 * cellSize * numRows));
        System.out.println("CELLSIZE NUMBERS" +3 * cellSize * numCols+","+ 3 * cellSize * numRows);
        addMouseListener(this);
        frame.getContentPane().add(this);
        //setMaximumSize(new Dimension(5*cellSize * numCols, 5*cellSize * numRows));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void showImage(BufferedImage image)
    {
        for (int row = 0; row < getNumRows(); row++)
        {
            for (int col = 0; col < getNumCols(); col++)
            {
                int x = col * image.getWidth() / getNumCols();
                int y = row * image.getHeight() / getNumRows();
                int c = image.getRGB(x, y);
                int red = (c & 0x00ff0000) >> 16;
                int green = (c & 0x0000ff00) >> 8;
                int blue = c & 0x000000ff;
                cells[row][col].setColor(new Color(red, green, blue));
            }
        }
        repaint();
    }

    private int getCellSize()
    {
        int cellWidth = getWidth() / getNumCols();
        int cellHeight = getHeight() / getNumRows();
        return Math.min(cellWidth, cellHeight);
    }

    public void keyPressed(KeyEvent e)
    {
        lastKeyPressed = e.getKeyCode();
        
        if(lastKeyPressed==17)
            holdCtrl=true;
        if(lastKeyPressed==90)
            holdZ=true;
        
    }

    public void keyReleased(KeyEvent e)
    {
        lastKeyReleased = e.getKeyCode();
        //ignored
        if(lastKeyReleased==17)
            holdCtrl=false;
        if(lastKeyReleased==90)
            holdZ=false;
    }

    public boolean getHoldCtrl()
    {
        return holdCtrl;
    }
    
    public boolean getHoldZ()
    {
        return holdZ;
    }
    
    public int getKeyReleased()
    {
        return lastKeyReleased;
    }
    public void keyTyped(KeyEvent e)
    {
        //ignored
    }

    public void mousePressed(MouseEvent e)
    {
        int cellSize = getCellSize();
        int row = e.getY() / cellSize;
        if (row < 0 || row >= getNumRows())
        {
            return;
        }
        int col = e.getX() / cellSize;
        if (col < 0 || col >= getNumCols())
        {
            return;
        }
        lastLocationClicked = new Location(row, col);
    }

    public void mouseReleased(MouseEvent e)
    {
        //ignore
    }

    public void mouseClicked(MouseEvent e)
    {
        //ignore
    }

    public void mouseEntered(MouseEvent e)
    {
        //ignore
    }

    public void mouseExited(MouseEvent e)
    {
        //ignore
    }

    private static java.awt.Color toJavaColor(Color color)
    {
        return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    //MENU BAR HERE!!!!!!!!!!!!!!!!
    public void paintComponent(Graphics g)
    {
        if(bgSet)
        {
            g.drawImage(backgroundImage, 0, 0, frame.getWidth(), frame.getHeight(), null);
        }
        
        if(blinkRec)
        {
            long time = System.currentTimeMillis();
            if (time % 1000 < 500)
            {
                g.setColor(java.awt.Color.WHITE);
                if (isGirl == false) //boy
                {
                    g.fillRect(222, 520, 355, 25);
                } else //girl
                {
                    g.fillRect(795, 520, 355, 25);
                }
            } else
            {
                g.setColor(java.awt.Color.BLACK);
                if (isGirl == false) //boy
                {
                    g.fillRect(222, 520, 355, 25);
                } else //girl
                {
                    g.fillRect(795, 520, 355, 25);
                }
            }
        }
        
        for (int row = 0; row < getNumRows(); row++)
        {
            for (int col = 0; col < getNumCols(); col++)
            {
                Location loc = new Location(row, col);
                Cell cell = cells[loc.getRow()][loc.getCol()];

                Color color = cell.getColor();

                g.setColor(toJavaColor(color));
                int cellSize = getCellSize();
                int x = col * cellSize;
                int y = row * cellSize;
                if (!bgSet)
                {
                    g.fillRect(x, y, cellSize, cellSize);
                }

                String imageFileName = cell.getImageFileName();
                if (imageFileName != null)
                {
                    URL url = getClass().getResource(imageFileName);
                    if (url == null)
                    {
                        System.out.println("File not found:  " + imageFileName);
                    } else
                    {

                        Image image = new ImageIcon(url).getImage();
                        int width = image.getWidth(null);
                        int height = image.getHeight(null);
                        int max;
                        if (width > height)
                        {
                            int drawHeight = cellSize * height / width;
                            g.drawImage(image, x, y + (cellSize - drawHeight) / 2, cellSize, drawHeight, null);
                        } else
                        {
                            int drawWidth = cellSize * width / height;

                            //g.drawOval(x + (cellSize - drawWidth) / 2, y, drawWidth, cellSize);
                            g.drawImage(image, x + (cellSize - drawWidth) / 2, y, drawWidth, cellSize, null);
                        }
                    }
                }

                if (lineColor != null)
                {
                    g.setColor(toJavaColor(lineColor));
                    g.drawRect(x, y, cellSize, cellSize);
                }
            }
        }
        
        //@MS UI GOTHIC 29 for name
        //malgun gothic 23 for dialogue
        if(cutscene)
        {
            //System.out.println("the current CS is "+currCS);
            
            ImageIcon d1 =new ImageIcon(Grid.class.getResource(cutsceneImgs[currCS]));// cutsceneIcons[currCS];
            g.drawImage(d1.getImage(), 93, 596, 1200, 300, null);
            
            //you will actually draw the image at cutsceneImgs[currCS]            
            //g.fillRect(100, 100, 200, 100);
            
        }
        
        //blackscreen
        if(blackScreen)
        {
            g.setColor(java.awt.Color.BLACK);
            g.fillRect(0, 0, 1500, 1500);
        }
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public boolean isValid(Location loc)
    {
        int row = loc.getRow();
        int col = loc.getCol();
        return 0 <= row && row < getNumRows() && 0 <= col && col < getNumCols();
    }

    public void setColor(Location loc, Color color)
    {
        if (!isValid(loc))
        {
            throw new RuntimeException("cannot set color of invalid location " + loc + " to color " + color);
        }
        cells[loc.getRow()][loc.getCol()].setColor(color);
        repaint();
    }

    public Color getColor(Location loc)
    {
        if (!isValid(loc))
        {
            throw new RuntimeException("cannot get color from invalid location " + loc);
        }
        return cells[loc.getRow()][loc.getCol()].getColor();
    }

    public void setImage(Location loc, String imageFileName)
    {
        if (!isValid(loc))
        {
            throw new RuntimeException("cannot set image for invalid location " + loc + " to \"" + imageFileName + "\"");
        }
        cells[loc.getRow()][loc.getCol()].setImageFileName(imageFileName);
        repaint();
    }

    public String getImage(Location loc)
    {
        if (!isValid(loc))
        {
            throw new RuntimeException("cannot get image for invalid location " + loc);
        }
        return cells[loc.getRow()][loc.getCol()].getImageFileName();
    }

    public static void pause(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } catch (Exception e)
        {
            //ignore
        }
    }

    //returns -1 if no key pressed since last call.
    //otherwise returns the code for the last key pressed.
    public int checkLastKeyPressed()
    {
        int key = lastKeyPressed;
        lastKeyPressed = -1;
        return key;
    }

    //returns null if no location clicked since last call.
    public Location checkLastLocationClicked()
    {
        Location loc = lastLocationClicked;
        lastLocationClicked = null;
        return loc;
    }

    public void load(String imageFileName)
    {
        showImage(loadImage(imageFileName));
        setTitle(imageFileName);
    }

    public void save(String imageFileName)
    {
        try
        {
            BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            paintComponent(bi.getGraphics());
            int index = imageFileName.lastIndexOf('.');
            if (index == -1)
            {
                throw new RuntimeException("invalid image file name:  " + imageFileName);
            }
            ImageIO.write(bi, imageFileName.substring(index + 1), new File(imageFileName));
        } catch (IOException e)
        {
            throw new RuntimeException("unable to save image to file:  " + imageFileName);
        }
    }

    public void setLineColor(Color color)
    {
        lineColor = color;
        repaint();
    }

    public void showMessageDialog(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    public String showInputDialog(String message)
    {
        return JOptionPane.showInputDialog(this, message);
    }
}
