package model.admin;

public class MemberFee {

    /* Author Simon Roswall Jørgensen
    *
    * Ikke Implementeret
    * */

    private double memberFee;
    private final double PASSIVE_FEE = 500;
    private final double JUNIOR_FEE = 1000;
    private final double SENIOR_FEE = 1600;
    private final double PENSION_REBATE_MULTIPLIER = 0.25;

    MemberFee(int age, boolean activityStatus){
        this.memberFee = calculateMemberFee(age, activityStatus);
    }

    public double calculateMemberFee(int age, boolean isActiveMember){
        if (!isActiveMember){
            return PASSIVE_FEE;
        } else if (age < 18){
            return JUNIOR_FEE;
        } else if (age >= 60 && isActiveMember){
            return SENIOR_FEE*PENSION_REBATE_MULTIPLIER;
        } else
            return SENIOR_FEE;
    }

    public double getMemberFee() {
        return memberFee;
    }
}
