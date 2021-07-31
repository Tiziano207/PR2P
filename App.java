import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Post post = new Post(0, "Marco", "Daje ci");
        Post post1 = new Post(1, "Paolo", "Ce sto zi");
        Post post2 = new Post(2, "Antonio", "Ce senti Cerqua??");
        Post post3 = new Post(3, "Antonio", "Ah boh veramente");

        post.addLike("Antonino");
        post1.addLike("Marco");
        post2.addLike("Pasquale");
        post2.addLike("Mastro Don Gesualdo");
        post2.addLike("Peppino l'infermiere");

        ArrayList<Post> listaPost = new ArrayList<Post>();
        listaPost.add(post);
        listaPost.add(post1);
        listaPost.add(post2);

        SocialNetwork microBlog = new SocialNetwork();

        microBlog.addUser("Pasquale");
        microBlog.addUser("Antonino");
        microBlog.addUser("Marco");
        microBlog.addUser("Antonio");
        microBlog.addUser("Mastro Don Gesualdo");
        microBlog.addUser("Peppino l'infermiere");

        microBlog.addPost(post);
        microBlog.addPost(post1);
        microBlog.addPost(post2);
        microBlog.addPost(post3);

        System.out.println(microBlog.getMentionedUsers());

        System.out.println("\nguessFollowers" + microBlog.guessFollowers(listaPost));

        System.out.println("influencers" + microBlog.influencers());

        // System.out.println("\nwrittenby" + microBlog.writtenBy("Antonio"));
        for (Post ps : microBlog.writtenBy("Antonio")) {
            // System.out.println("\nwrittenbyList" + microBlog.writtenBy(listaPost,
            // "Antonio"));
            System.out.println("\nwrittenbyList " + ps.getText());
        }

        for (Post ps : microBlog.writtenBy(listaPost, "Antonio")) {
            // System.out.println("\nwrittenbyList" + microBlog.writtenBy(listaPost,
            // "Antonio"));
            System.out.println("\nwrittenbyList " + ps.getText());
        }

        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("boh");

        for (Post ps : microBlog.containing(wordList)) {
            // System.out.println("\nwrittenbyList" + microBlog.writtenBy(listaPost,
            // "Antonio"));
            System.out.println("\nContaining " + ps.getText());
        }
        // _______________________________________________________________________________________________________
        SocialNetworkRepostOffensivePost microblogfiltered = new SocialNetworkRepostOffensivePost();
        microblogfiltered.addBlackList("Bamba");
        microblogfiltered.addBlackList("Droka");

        System.out.println("\nBlakList:");
        for (String word : microblogfiltered.getBlackList()) {
            System.out.println("\n" + word);
        }
        Post postF0 = new Post(0, "Lapo Elkan", "mi voglio fare di Bianca");
        microblogfiltered.addPost(postF0);

        Post postF1 = new Post(1, "Berlusconi", "mi va proprio di drogarmi");
        microblogfiltered.addPost(postF1);

        System.out.println(microblogfiltered.getPost());
        System.out.println("SenzaFiltri\n");

        microblogfiltered.addPostinBlackList(postF0);
        microblogfiltered.controlReport(postF0);
        microblogfiltered.addPostinBlackList(postF0);
        microblogfiltered.controlReport(postF0);
        microblogfiltered.addPostinBlackList(postF0);
        microblogfiltered.controlReport(postF0);

        System.out.println("Con Segnalazioni\n");
        System.out.println(microblogfiltered.getPost());
        // Post postF2 = new Post(2, "Lapo Elkan", "mi voglio fare di Bamba");
        // microblogfiltered.addPost(postF2);
    }
}
