import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class simpleoscillation extends PApplet {

// Simple Oscillation
// The Nature of Code
// Daniel Shiffman <http://www.shiffman.net>

// Doing oscillation with velocity
float xtheta;
float xtheta_vel;

// Having two separate variables for x,y is not so great
// This could be improved by using our Vector3D class!
float ytheta;
float ytheta_vel;

// A counter in case we want to oscillate with period calculated as number of frames
// float framecounter = 0.0f;

public void setup() {
  size(200,200);
  smooth();
  xtheta = ytheta = 0.0f;
  xtheta_vel = 0.05f;
  ytheta_vel = 0.0332f;
}

public void draw() {
  background(255);

  // Calculate oscillation along x axis
  float amplitude = 75.0f;
  float x = amplitude * sin(xtheta);
  xtheta += xtheta_vel;

  // Calculate oscillation along y axis
  amplitude = 50.0f;
  float y = amplitude * cos(ytheta);
  ytheta += ytheta_vel;  
      
  // Period as # of frames
  /*float period = 600.0;
  float amplitude = 75.0;
  float x = amplitude * cos(TWO_PI * framecounter / period);
  framecounter++;*/
  
  ellipseMode(CENTER);
  stroke(0);
  fill(175);
  translate(width/2,height/2);  // Move origin to center of screen
  line(0,0,x,y);
  ellipse(x,y,20,20);

}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "simpleoscillation" });
  }
}
