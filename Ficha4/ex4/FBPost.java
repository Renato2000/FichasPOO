import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Iterator;

public class FBPost{
	int id;
	String nome;
	LocalDateTime data;
	String conteudo;
	int likes;
	List<String> comentarios;

	public FBPost(){
		this.id = 0;
		this.nome = new String();
		this.data = LocalDateTime.now();
		this.conteudo = new String();
		this.likes = 0;
		this.comentarios = new ArrayList<String>();
	}

	public FBPost(int nid, String nnome, LocalDateTime ndata, String nconteudo, int nlikes, List<String> ncomentarios){
		this.id = nid;
		this.nome = nnome;
		this.data = ndata;
		this.conteudo = nconteudo;
		this.likes = nlikes;
		this.setComentarios(ncomentarios);
	}

	public FBPost(FBPost post){
		this.id = post.getId();
		this.nome = post.getNome();
		this.data = post.getData();
		this.conteudo = post.getConteudo();
		this.likes = post.getLikes();
		this.setComentarios(post.getComentarios());
	}

	public int getId(){
		return this.id;
	}

	public String getNome(){
		return this.nome;
	}

	public LocalDateTime getData(){
		return this.data;
	}

	public String getConteudo(){
		return this.conteudo;
	}

	public int getLikes(){
		return this.likes;
	}

	public List<String> getComentarios(){
		return getComentariosInternalIterator();
	}

	private List<String> getComentariosInternalIterator(){
		ArrayList<String> novo = new ArrayList<>();
		this.comentarios.stream().forEach(a -> novo.add(a));
		return novo;
	}

	private List<String> getComentariosExternalIterator(){
		ArrayList<String> novo = new ArrayList<>();
		for(String aux : this.comentarios){
			novo.add(aux);
		}
		return novo;
	}

	private List<String> getComentariosIterator(){
		ArrayList<String> novo = new ArrayList<>();
		Iterator<String> it = this.comentarios.iterator();
		while(it.hasNext()){
			String aux = it.next();
			novo.add(aux);
		}
		return novo;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setData(LocalDateTime data){
		this.data = data;
	}

	public void setConteudo(String conteudo){
		this.conteudo = conteudo;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public void setComentarios(List<String> c){
		setComentariosInternalIterator(c);
	}	

	private void setComentariosInternalIterator(List<String> c){
		this.comentarios = new ArrayList<>();
		c.stream().forEach(a -> this.comentarios.add(a));
	}

	private void setComentariosExternalIterator(List<String> c){
		this.comentarios = new ArrayList<>();
		for(String aux : c){
			this.comentarios.add(aux);
		}
	}

	private void setComentariosIterator(List<String> c){
		this.comentarios = new ArrayList<>();
		Iterator<String> it = this.comentarios.iterator();
		while(it.hasNext()){
			String aux = it.next();
			this.comentarios.add(aux);
		}
	}

	public String toString(){
		Iterator<String> it = this.comentarios.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id 
					+ "\nNome:" + this.nome 
					+ "\nData: " + this.data 
					+ "\nConteudo: " + this.conteudo 
					+ "\nLikes: " + this.likes
					+ "\nComentarios: ");

		while(it.hasNext()){
			String elem = it.next();
			sb.append(elem).append("\n");
		}

		return sb.append("\n").toString();
	}

	public FBPost clone(){
		return new FBPost(this);
	}

	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		FBPost f = (FBPost) o;
		if(this.comentarios.size() != f.getComentarios().size()) return false;
		return f.getComentarios().stream().allMatch(a -> this.comentarios.contains(a));
		//retrun this.comentarios.containsAll(f);
	}

	public void addComentario(String comentario){
		this.comentarios.add(comentario);
	}

	public void addLike(){
		this.likes = this.likes + 1;
	}

	int compareTo(FBPost f){
		return f.getComentarios().size() - this.comentarios.size();
	}
}