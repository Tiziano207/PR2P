import java.util.*;

public class SocialNetworkRepostOffensivePost extends SocialNetwork {
    private List<String> blackList = new ArrayList<String>();
    private ArrayList<Post> blackListPost = new ArrayList<Post>();
    private HashMap<Integer, Integer> reportedPost = new HashMap<>();

    public SocialNetworkRepostOffensivePost() {
    }

    // controllo dei post che vengono immessi nella rete
    public void addPost(Post ps) throws ExplicitLanguageException {
        for (String badWord : blackList) {
            if (!ps.getText().contains(badWord))
                super.getPost.put(ps.getIDPost(), ps);
            else
                throw new ExplicitLanguageException("You can't use strong Language");
        }
        return;
    }
    // se ci sono due segnalazioni tolgo il post
    // una persona può segnalare più volte reportedPost.get(ps.getIDPost() + 1)

    public void addPostinBlackList(Post ps) {

        if (reportedPost.containsKey(ps.getIDPost())) {
            Integer tmp = reportedPost.get(ps.getIDPost());
            reportedPost.put(ps.getIDPost(), tmp + 1);
        } else {
            reportedPost.put(ps.getIDPost(), 1);
        }
        return;
    }

    public void controlReport(Post ps) {
        if (!super.getPost().containsKey(ps.getIDPost())) {
            System.out.println("Il Post è stato rimosso");
            return;
        }
        if (reportedPost.get(ps.getIDPost()) >= 2) {
            System.out.println("Le segnalazioni sono diventate Troppe il Post sarà rimosso");
            removeOffensivePost(ps);
        }
        return;
    }

    public void removeOffensivePost(Post ps) {
        super.getPost.remove(ps.getIDPost());
        blackListPost.remove(ps);
        return;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void addBlackList(String badWord) {
        if (!blackList.contains(badWord)) {
            blackList.add(badWord);
        }
        return;
    }

    public void removeWordBlacklist(String badWord) {
        blackList.remove(badWord);
    }

    public HashMap<Integer, Post> getPost() {
        return super.getPost();
    }

}
