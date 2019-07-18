package dataSource;

public class GitInfo {

    private String repositoryName;
    private String repositoryEmail;
    private String repositoryBranch;
    public GitInfo(String repositoryName, String repositoryEmail, String repositoryBranch) {
        super();
        this.repositoryName = repositoryName;
        this.repositoryEmail = repositoryEmail;
        this.repositoryBranch = repositoryBranch;
    }

    /**
     * Return the full application information.
     */
    @Override
    public String toString() {
        return repositoryName + " " + repositoryEmail + "_" + repositoryBranch;
    }

    public String getRepositoryName() {
        return this.repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryEmail() {
        return this.repositoryEmail;
    }

    public void setRepositoryEmail(String repositoryEmail) {
        this.repositoryEmail = repositoryEmail;
    }

    public String getRepositoryBranch() {
        return repositoryBranch;
    }

    public void setRepositoryBranch(String repositoryBranch) {
        this.repositoryBranch = repositoryBranch;
    }
}