import processing.core.*; import java.applet.*; import java.awt.*; import java.awt.image.*; import java.awt.event.*; import java.io.*; import java.net.*; import java.text.*; import java.util.*; import java.util.zip.*; public class NoiseWave extends PApplet {// Noise Wave
// Daniel Shiffman <http://www.shiffman.net>

// Using Perlin Noise to generate a wave-like pattern

// Created 2 May 2005

int xspacing = 8;   // How far apart should each horizontal location be spaced
int w;              // Width of entire wave

float yoff = 0.0f;        // 2nd dimension of perlin noise
float[] yvalues;          // Using an array to store height values for the wave (not entirely necessary)

public void setup() {
  size(200,200);
  framerate(30);
  colorMode(RGB,255,255,255,100);
  smooth();
  w = width+16;
  yvalues = new float[w/xspacing];
}

public void draw() {
  background(100);
  calcWave();
  renderWave();

}

public void calcWave() {
  float dx = 0.05f;
  float dy = 0.01f;
  float amplitude = 100.0f;

  // Increment y ('time')
  yoff += dy;

  //float xoff = 0.0;  // Option #1
  float xoff = yoff; // Option #2

  for (int i = 0; i < yvalues.length; i++) {
    // Using 2D noise function
    //yvalues[i] = (2*noise(xoff,yoff)-1)*amplitude; // Option #1
    // Using 1D noise function
    yvalues[i] = (2*noise(xoff)-1)*amplitude;    // Option #2
    xoff+=dx;
  }

}

public void renderWave() {
  // A simple way to draw the wave with an ellipse at each location
  for (int x = 0; x < yvalues.length; x++) {
    noStroke();
    fill(255,50);
    ellipseMode(CENTER);
    ellipse(x*xspacing,width/2+yvalues[x],16,16);
  }
}

static public void main(String args[]) {   PApplet.main(new String[] { "NoiseWave" });}}