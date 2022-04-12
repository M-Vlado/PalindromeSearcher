package com.company;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuperHexagon {

  // OPTIONS
  static int SIZE = 320;
  static boolean useColoredHexagons = true;

  public static void drawImage(Graphics graphics) {

    //chose how many hexagon do you want to have on one side of Hexagon
    int howManyHexagonForSize = 4;

    //calculate with of single hexagon
    int withOfHexagon = (SIZE / ((howManyHexagonForSize * 2) - 1));
    //calculate height of single hexagon
    int heightOfHexagon = (int) ((Math.sqrt(3)) * (withOfHexagon / 2));
    //calculate a middle point X for first hexagon on the canvas
    int middleStartingPointX =
        (int) ((SIZE - ((withOfHexagon * 0.75) * ((howManyHexagonForSize * 2) - 1))) / 2) +
            withOfHexagon / 4;
    //calculate a middle point Y for first hexagon on the canvas
    int middleStartingPointY =
        ((SIZE - (heightOfHexagon * ((howManyHexagonForSize * 2) - 1))) / 2) +
            (heightOfHexagon * howManyHexagonForSize / 2);

    drawInQuarters(middleStartingPointX, middleStartingPointY, graphics, howManyHexagonForSize,
        withOfHexagon, heightOfHexagon);

  }

  public static void drawInQuarters(int middleStartingPointX, int middleStartingPointY, Graphics g,
                                    int howManyHexagonOnForSize, int withOfHexagon,
                                    int highOfHexagon) {

    int hexagonsInColumnCounter = howManyHexagonOnForSize;
    int columnsCounter = 2 * howManyHexagonOnForSize - 1;

    Random random = new Random();

    //set an array of coordinates X, Y, for the drawPolygon
    int[] xPoints =
        {middleStartingPointX - (withOfHexagon / 2), middleStartingPointX - (withOfHexagon / 4),
            middleStartingPointX + (withOfHexagon / 4), middleStartingPointX + (withOfHexagon / 2),
            middleStartingPointX + (withOfHexagon / 4), middleStartingPointX - (withOfHexagon / 4)};

    int[] yPoints = {middleStartingPointY, middleStartingPointY - (highOfHexagon / 2),
        middleStartingPointY - (highOfHexagon / 2), middleStartingPointY,
        middleStartingPointY + (highOfHexagon / 2), middleStartingPointY + (highOfHexagon / 2)};

    //first for loop is drawing each column of hexagon
    for (int i = 1; i <= columnsCounter; i++) {

      //second for loop is drawing each hexagon in the column
      for (int j = 1; j <= hexagonsInColumnCounter; j++) {

        if(useColoredHexagons){
          Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
          g.setColor(color);
          g.fillPolygon(xPoints,yPoints,6);
        }else {
          g.drawPolygon(xPoints, yPoints, 6);
        }

        if (j != hexagonsInColumnCounter) {
          //change coordinates Y for next position of hexagon in the column
          yPoints[0] += highOfHexagon;
          yPoints[1] += highOfHexagon;
          yPoints[2] += highOfHexagon;
          yPoints[3] += highOfHexagon;
          yPoints[4] += highOfHexagon;
          yPoints[5] += highOfHexagon;

        } else if (i < howManyHexagonOnForSize) {
          // reset position Y for the next column of the hexagon in the first half
          yPoints[0] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon / 2);
          yPoints[1] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon / 2);
          yPoints[2] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon / 2);
          yPoints[3] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon / 2);
          yPoints[4] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon / 2);
          yPoints[5] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon / 2);

        } else {
          // reset position Y for the next column of the hexagon in the second half
          yPoints[0] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon * 1.5);
          yPoints[1] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon * 1.5);
          yPoints[2] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon * 1.5);
          yPoints[3] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon * 1.5);
          yPoints[4] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon * 1.5);
          yPoints[5] -= hexagonsInColumnCounter * highOfHexagon - (highOfHexagon * 1.5);

        }

      }
      // //change coordinates X for next column of hexagons
      xPoints[0] += withOfHexagon * 0.75;
      xPoints[1] += withOfHexagon * 0.75;
      xPoints[2] += withOfHexagon * 0.75;
      xPoints[3] += withOfHexagon * 0.75;
      xPoints[4] += withOfHexagon * 0.75;
      xPoints[5] += withOfHexagon * 0.75;


      if (i < howManyHexagonOnForSize) {
        hexagonsInColumnCounter++;
      } else {
        hexagonsInColumnCounter--;
      }
    }

  }


  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Super Hexagon");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(SIZE, SIZE));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      drawImage(graphics);
    }
  }
}
