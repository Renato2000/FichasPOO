import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Iterator;

public class FBFeed{
	private List<FBPost> feed;

	public FBFeed(){
		this.feed = new ArrayList<FBPost>();
	}

	public FBFeed(List<FBPost> feed){
		this.setFeed(feed);
	}

	public FBFeed(FBFeed f){
		this.setFeed(f.getFeed());
	}

	public List<FBPost> getFeed(){
		return this.getFeedInternalIterator();
	}

	private List<FBPost> getFeedInternalIterator(){
		return this.feed
					.stream()
					.map(FBPost::clone)
					.collect(Collectors.toList());
	}

	private List<FBPost> getFeedExernalIterator(){
		ArrayList<FBPost> novo = new ArrayList<>();
		for(FBPost f : this.feed)
			novo.add(f.clone());
		return novo;
	}

	private List<FBPost> getFeedIterator(){
		ArrayList<FBPost> novo = new ArrayList<>();
		Iterator<FBPost> it = this.feed.iterator();
		while(it.hasNext()){
			FBPost aux = it.next();
			novo.add(aux.clone());
		}
		return novo;
	}	

	public void setFeed(List<FBPost> f){
		this.setFeedInternalIterator(f);
	}

	private void setFeedInternalIterator(List<FBPost> f){
		this.feed = f.stream()
							.map(FBPost::clone)
							.collect(Collectors.toList());
	}

	private void setFeedExternalIterator(List<FBPost> f){
		this.feed = new ArrayList<>();
		for(FBPost aux : f)
			this.feed.add(aux.clone());
	}

	private void setFeedIterator(List<FBPost> f){
		this.feed = new ArrayList<>();
		Iterator<FBPost> it = this.feed.iterator();
		while(it.hasNext()){
			FBPost aux = it.next();
			this.feed.add(aux.clone());
		}
	}

	public FBFeed clone(){
		return new FBFeed(this);
	}

	public String toString(){
		String res = "";
		Iterator<FBPost> it = this.feed.iterator();
		while(it.hasNext()){
			res = res + "\n" it.next().toString();
		}
		return res;
	}

	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		FBFeed f = (FBFeed) o;
		if(this.feed.size() != f.getFeed().size()) return false;
		return f.getFeed().stream().allMatch(a -> this.feed.contains(a));
	}

	public int nrPosts(String user){
		int nr = 0;
		return this.feed.stream()
					.filter(p -> p.getNome().equals(p))
					.collect(Collectors.toList())
					.size();
	}

	public List<FBPost> postOf(String user){
		return this.feed
					.stream()
					.filter(p -> p.getNome().equals(user))
					.collect(Collectors.toList());
	}

	public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
		return this.feed
					.stream()
					.filter(p -> p.getNome().equals(user) && p.getData().isAfter(inicio) && p.getData().isBefore(fim))
					.collect(Collectors.toList());
	}

	public FBPost getPost(int id){
		for(FBPost f : this.feed){
			if(f.getId() == id) return f.clone();
		}
		return null;
	}

	public void comment(FBPost post, String comentario){
		for(FBPost f : this.feed){
			if(f.equals(post)) {
				f.addComentario(comentario);
				break; 
			}
		}
		
		/*
		this.feed
			.stream()
			.filter(p -> p.equals(post))
			.collect(Collectors.toList())
			.map(FBPost::addComentario(comentario));
		*/
	}	

	public void like(FBPost post){
		for(FBPost f : this.feed){
			if(f.equals(post)){
				f.addLike();
				break; 
			}
		}	

		/*
		this.feed
			.stream()
			.filter(p -> p.equals(post))
			.map(FBPost::like)
			.collect(Collectors.toList());
		*/
	}

	public void like(int postid){
		for(FBPost f : this.feed){
			if(f.getId() == postid) {
				f.addLike();
				break; 
			}
		}	

		/*
		this.feed
			.stream()
			.filter(p -> p.getId() == postid)
			.map(FBPost::like)
			.collect(Collectors.toList());
		*/
	}

	public List<Integer> top5Comments(){
		return top5CommentsInternalIterator();
	}

	public List<Integer> top5CommentsInternalIterator(){
		return this.feed
					.stream()
					.map(FBPost::clone)
					.sorted((a,b) -> a.getComentarios().size() - b.getComentarios().size())
					.map(FBPost::getId)
					.collect(Collectors.toList())
					.subList(0, 4);
	}

	public List<Integer> top5CommentsExternalIterator(){
		ArrayList<Integer> novo = new ArrayList<>();
		ArrayList<FBPost> aux = new ArrayList<>();
		int n=0;
		for(FBPost f : this.feed){
			for(FBPost a : aux){
				n=0;
				if(f.compareTo(a) > 0) n++;
			}
			aux.add(n, f.clone());
		}
		for(int i=0; i<5; i++){
			novo.add(aux.get(i).getComentarios().size());
		}
		return novo;
	}

	public void addPost(FBPost a){
		this.feed.add(a.clone());
	}
}