import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.plaf.FontUIResource;

public class GeradoraDeFigurinhas {
    

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception  {
        

                // leitura da imagem 
        //InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));

        // InputStream inputStream = new URL("AQUI COLOCA O LINK DE UMA URL DE IMAGEM").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem com transparencia  e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);



        //copiar a imagem original para nova imagem (em memoria)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        // configurar a fonte 

        var fonte = new FontUIResource(Font.SANS_SERIF, Font.BOLD, 30);
        graphics.setColor(Color.PINK);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem 

        graphics.drawString("TOPZERA", 0, novaAltura - 0);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));


       }

     



}