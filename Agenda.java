import java.util.ArrayList;
import java.util.Scanner;



class Contato {
private String nome;
private String telefone;



public Contato(String nome, String telefone) {
this.nome = nome;
this.telefone = telefone;
}


public String getNome() {
return nome;
}



public String getTelefone() {
return telefone;
}
}



public class Agenda {
private ArrayList<Contato> contatos;
private Scanner scanner;



public Agenda() {
contatos = new ArrayList<>();
scanner = new Scanner(System.in);
}



public void adicionarContato(String nome, String telefone) {
Contato contato = new Contato(nome, telefone);
contatos.add(contato);
System.out.println("Contato adicionado com sucesso.");
}



public void exibirContatos() {
if (contatos.isEmpty()) {
System.out.println("Agenda vazia.");
} else {
System.out.println("Contatos:");
for (Contato contato : contatos) {
System.out.println("Nome: " + contato.getNome());
System.out.println("Telefone: " + contato.getTelefone());
System.out.println("------");
}
}
}



public void removerContato(String nome) {
boolean encontrado = false;
for (Contato contato : contatos) {
if (contato.getNome().equalsIgnoreCase(nome)) {
contatos.remove(contato);
encontrado = true;
System.out.println("Contato removido com sucesso.");
break;
}
}
if (!encontrado) {
System.out.println("Contato não encontrado.");
}
}



public void fecharAgenda() {
scanner.close();
System.out.println("Agenda fechada.");
}



public static void main(String[] args) {
Agenda agenda = new Agenda();
Scanner scanner = new Scanner(System.in);
int opcao = 0;



while (opcao != 4) {
System.out.println("Agenda - Escolha uma opção:");
System.out.println("1. Adicionar contato");
System.out.println("2. Exibir contatos");
System.out.println("3. Remover contato");
System.out.println("4. Fechar agenda");


System.out.print("Opção: ");
opcao = scanner.nextInt();
scanner.nextLine(); // Consumir a quebra de linha após a leitura do inteiro



switch (opcao) {
case 1:
System.out.print("Nome: ");
String nome = scanner.nextLine();
System.out.print("Telefone: ");
String telefone = scanner.nextLine();
agenda.adicionarContato(nome, telefone);
break;
case 2:
agenda.exibirContatos();
break;
case 3:
System.out.print("Nome: ");
String nomeRemover = scanner.nextLine();
agenda.removerContato(nomeRemover);
break;
case 4:
agenda.fecharAgenda();
break;
default:
System.out.println("Opção inválida. Tente novamente.");
break;
}
}
}
}