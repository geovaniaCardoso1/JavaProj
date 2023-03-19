public class Livro {
    
    private String nome;
    private String autor, editora, genero;
    private Double preco;
    private Integer codigo;

    public Livro() {
    }

    public Livro(String nome, String autor, String editora, String genero, Double preco, Integer codigo) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.preco = preco;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ");
        sb.append(nome + "\n");
        sb.append("Autor: ");
        sb.append(autor + "\n");
        sb.append("Editora: ");
        sb.append(editora + "\n");
        sb.append("Genêro: ");
        sb.append(genero + "\n");
        sb.append("Preço: ");
        sb.append(String.format("%.2f", preco) + "\n");
        sb.append("Código: ");
        sb.append("#" + codigo);
        
        return sb.toString();
    }
}
