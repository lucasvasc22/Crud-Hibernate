package view;

import javax.swing.JFrame;

import controller.AlunoJpaDAO;
import model.Alunos;

public class App
{
    public static void main( String[] args )
    {
    	 Alunos alunos = new Alunos();
         alunos.setId_aluno(1);
         alunos.setNome("Lucas Vasconcelos");
         alunos.setEndereco("Rua Guaraitá");
         
         AlunoJpaDAO.getInstance().merge(alunos);
         System.out.println("Aluno salvo com sucesso!!!");
    }
}