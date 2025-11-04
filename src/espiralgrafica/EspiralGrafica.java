/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package espiralgrafica;

import javax.swing.*;
import java.awt.*;

public class EspiralGrafica extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Adiciona antialiasing para linhas mais suaves

        int xc = getWidth() / 2;
        int yc = getHeight() / 2;
        int a = 0; // Constante de ajuste
        int b = 5; // Constante para controlar a densidade da espiral
        int n = 400; // Número de pontos
        double dt = 12.0 * Math.PI / n; // Passo do ângulo

        // Cor da linha e dos pontos
        g2.setColor(Color.BLUE);

        int xAnterior = xc;
        int yAnterior = yc;

        for (int i = 1; i <= n; i++) {
            double t = dt * i;
            double r = a + b * t;
            double x = r * Math.cos(t);
            double y = r * Math.sin(t);

            int xAtual = (int) (xc + x);
            int yAtual = (int) (yc - y);

            // Desenha a linha entre o ponto anterior e o ponto atual (a partir do segundo ponto)
            if (i > 1) {
                g2.drawLine(xAnterior, yAnterior, xAtual, yAtual);
            }

            // Desenha um oval preenchido para representar o ponto
            // `fillOval(x, y, largura, altura)`
            // É preciso ajustar as coordenadas para centralizar o ponto
            int diametroPonto = 7;
            g2.fillOval(xAtual - diametroPonto / 2, yAtual - diametroPonto / 2, diametroPonto, diametroPonto);

            xAnterior = xAtual;
            yAnterior = yAtual;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Espiral de Arquimedes com Pontos e Linhas");
        EspiralGrafica painel = new EspiralGrafica();
        frame.add(painel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


