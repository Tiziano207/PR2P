import java.util.*;
import java.util.Map.Entry;

public class SocialNetwork {

    private HashMap<String, ArrayList<String>> retesociale;
    private HashMap<Integer, Post> postMap;

    public SocialNetwork() {
        retesociale = new HashMap<String, ArrayList<String>>();
        postMap = new HashMap<Integer, Post>();
    }

    public HashMap<String, ArrayList<String>> guessFollowers(List<Post> ps) {
        HashMap<String, ArrayList<String>> socialDerivateFromPost = new HashMap<String, ArrayList<String>>();

        // ho messo le chiavi dentro l'HashMap con tutti gli autori presi dai Post
        for (Post post : ps) {
            socialDerivateFromPost.put(post.getAuthor(), new ArrayList<String>());
        }
        // ora devo derivare da ogni chiave la lista dei follower associata,
        // inserisco quello che trovo dalla strutura dati Post.likes nell'Hasmap
        for (Post postIterator : ps) {
            for (int i = 0; i < postIterator.getFollowers().size() - 1; i++)
                socialDerivateFromPost.put(postIterator.getAuthor(), postIterator.getFollowers());
        }
        return socialDerivateFromPost;
    }

    public List<String> influencers() {
        HashMap<String, Integer> influencersMap = new HashMap<String, Integer>();

        for (Post post : postMap.values()) {
            if (!influencersMap.containsKey(post.getAuthor())) {
                influencersMap.put(post.getAuthor(), post.getFollowers().size());
                System.out.println(post.getFollowers().size());
            } else {
                Integer tmp;
                tmp = influencersMap.get(post.getAuthor());
                influencersMap.put(post.getAuthor(), tmp + post.getFollowers().size());
                System.out.println(post.getFollowers().size());
            }
        }

        Set<Entry<String, Integer>> entrySet = influencersMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(entrySet);
        list.sort(Map.Entry.comparingByValue());

        List<String> sortedInfluencers = new ArrayList<String>();

        for (int i = list.size() - 1; i >= 0; i--) {
            sortedInfluencers.add(list.get(i).getKey());
        }

        return sortedInfluencers;
    }

    public Set<String> getMentionedUsers() {
        return retesociale.keySet();
    }

    public Set<String> getMentionedUsers(List<Post> ps) {
        Set<String> mentionedUsersFromPost = new HashSet<String>();

        for (Post post : ps) {
            mentionedUsersFromPost.add(post.getAuthor());
        }
        return mentionedUsersFromPost;
    }

    public List<Post> writtenBy(String username) {
        List<Post> postFromAuthor = new ArrayList<Post>();
        for (Post post : postMap.values()) {
            if (post.getAuthor().equals(username))
                postFromAuthor.add(post);
        }
        return postFromAuthor;

    }

    public List<Post> writtenBy(List<Post> ps, String username) {
        List<Post> postFromAuthor = new ArrayList<Post>();
        for (Post post : ps) {
            if (post.getAuthor().equals(username))
                postFromAuthor.add(post);
        }
        return postFromAuthor;
    }

    // da rivedere
    public List<Post> containing(List<String> words) {
        List<Post> postWwords = new ArrayList<Post>();
        for (Post post : postMap.values()) {
            for (String word : words)
                if (post.getText().contains(word))
                    postWwords.add(post);
        }
        return postWwords;
    }

    public void addUser(String name) throws UserCannotBeEqualException {
        if (!retesociale.containsKey(name))
            retesociale.put(name, new ArrayList<String>());
        else
            throw new UserCannotBeEqualException("User can't have same Nickname");
        return;

    }

    public void addPost(Post ps) throws ExplicitLanguageException {
        postMap.put(ps.getIDPost(), ps);
        return;
    }

    public HashMap<Integer, Post> getPost() {
        return postMap;
    }
}