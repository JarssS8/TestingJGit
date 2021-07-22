import org.eclipse.jgit.api.*;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.IOException;

public class Main {
    public static void main(String[] params) {
        try {

            // Initial values
            Repository localRepo = new FileRepository("PATH-TO-.git-folder");
            Git git = new Git(localRepo);
            // Add
            AddCommand addCommand = git.add();
            addCommand.addFilepattern("FILE-PATH").call();

            // Commit
            CommitCommand commit = git.commit();
            commit.setMessage("COMMIT-MESSAGE").call();

            // Add remote repo:
            RemoteAddCommand remoteAddCommand = git.remoteAdd();
            remoteAddCommand.setName("origin");
            remoteAddCommand.setUri(new URIish("REPO-URL"));
            // you can add more settings here if needed
            remoteAddCommand.call();

            // Push to remote:
            PushCommand pushCommand = git.push();
            // CREDENTIALS NEVER SHOULD BE SHOWED IN CODE
            // you can add more settings here if needed
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("username", "password"));
            pushCommand.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
