package core.ok;

public class OkMessagesPage {
    protected static OkMessagesPage page;

    protected OkMessagesPage() {
    }

    public static OkMessagesPage getInstance() {
        if (page == null) {
            page = new OkMessagesPage();
        }
        return page;
    }


    /**
     * @param fullName of user
     * @return first found dialog
     */
    public OkDialog chooseDialog(String fullName) {
        return OkDialog.getByName(fullName);
    }

}
