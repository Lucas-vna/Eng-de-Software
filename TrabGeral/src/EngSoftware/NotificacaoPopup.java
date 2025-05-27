/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EngSoftware;

/**
 *
 * @author victo
 */
public class NotificacaoPopup implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[POP-UP] " + mensagem);
    }
}