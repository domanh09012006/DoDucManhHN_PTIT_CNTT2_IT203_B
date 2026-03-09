package SESSION02.BT5;

class SuperAdmin implements UserActions, AdminActions {
    @Override
    public void logActivity(String activity) {
        AdminActions.super.logActivity(activity);
    }
}
