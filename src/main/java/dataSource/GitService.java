package dataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitService {

    private static final String UNKNOWN = "unknown";
    private static final Logger LOG = LoggerFactory.getLogger(GitService.class);

    public GitInfo getGitInfo() {
        String repositoryName = UNKNOWN;
        String repositoryEmail = UNKNOWN;
        String repositoryBranch = UNKNOWN;

        repositoryName = getBranchName();
        repositoryEmail = getRepositoryName();
        repositoryBranch = getRepositoryEmail();

        return new GitInfo(repositoryName, repositoryEmail, repositoryBranch);
    }

    private String getBranchName() {
        String line = "";

        try {
            Process process = Runtime.getRuntime().exec("git rev-parse --abbrev-ref HEAD");
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            line = reader.readLine();
        } catch (IOException | InterruptedException var3) {
            var3.printStackTrace();
        }

        return line;
    }

    private String getRepositoryName() {
        String line = "";

        try {
            Process process = Runtime.getRuntime().exec("git rev-parse --show-toplevel");
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String[] lineArray = reader.readLine().split("\\/");
            line = lineArray[lineArray.length - 1];
        } catch (IOException | InterruptedException var4) {
            var4.printStackTrace();
        }

        return line;
    }

    private String getRepositoryEmail() {
        String line = "";

        try {
            Process process = Runtime.getRuntime().exec("git config user.email");
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            line = reader.readLine();
        } catch (IOException | InterruptedException var3) {
            var3.printStackTrace();
        }

        return line;
    }

}