public class SomeClass {

    private static final String OUTPUT_FORMAT = "%-15s %4s %4s %5s %4s %-15s %s";

    private static final String[] HEADER = new String[] {
        "Filesystem",
        "Size",
        "Used",
        "Avail",
        "Use%",
        "Mounted on",
        "Type"
    };
    private static final String[] IHEADER = new String[] {
        "Filesystem",
        "Inodes",
        "IUsed",
        "IFree",
        "IUse%",
        "Mounted on",
        "Type"
    };


    public SomeClass(Shell shell) {
        super(shell);
        setOutputFormat(OUTPUT_FORMAT);
        this.completer = new FileCompleter(shell);
    }

    public SomeClass() {
        super();
        setOutputFormat(OUTPUT_FORMAT);
    }

    public GetlineCompleter getCompleter() {
        return this.completer;
    }

    protected boolean validateArgs(String[] args) {
        return true;
    }

    public String getSyntaxArgs() {
        return "[filesystem]";
    }

    public String getUsageShort() {
        return "Report filesystem disk space usage";
    }

    public void printHeader() {
        printf(this.opt_i ? IHEADER : HEADER);
    }
}
