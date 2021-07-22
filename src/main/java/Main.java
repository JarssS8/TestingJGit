import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] params) throws IOException {
        System.out.println("Hola");
        Git git = Git.open(new File("E:/Programming/JGit/.git/"));
    }
}
