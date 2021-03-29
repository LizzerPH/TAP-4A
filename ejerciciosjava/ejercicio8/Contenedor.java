package ejerciciosjava.ejercicio8;
import java.awt.*;

public class Contenedor extends Canvas{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int x, y;
    private int w, h;
    private boolean isClicked;
    private Image imagen;
    private Image buffer;
    private Image images[];
    private int t;

    public Contenedor() {
        x = 30;
        y = 30;
        isClicked = false;
        images = new Image[5];
        String pathImage = "/Users/LizzerPoolHuchim/Documents/GitHub/TAP-4A/ejerciciosjava/ejercicio8/recursos/fondo.jpg";
        imagen = Toolkit.getDefaultToolkit().getImage(pathImage);
        this.t = 0;
        for(int i=1;i <= 5; i++) {
            images[i-1] = Toolkit.getDefaultToolkit().getImage("/Users/LizzerPoolHuchim/Documents/GitHub/TAP-4A/ejerciciosjava/ejercicio8/recursos/" + i + ".png");
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        buffer = createImage(1024,500);
        Graphics miG = buffer.getGraphics();
        miG.setColor(Color.white);
        miG.fillRect(0,0, 1024, 500);
        miG.drawImage(imagen, 0, 0, 1024,500, this);
        miG.drawImage(images[this.t], x, y+100, this);
        g2d.drawImage(buffer, 0, 0, this);
    }

    public void tick() {
        this.t++;
        if(t>=images.length) this.t=0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = !this.isClicked;
    }
}