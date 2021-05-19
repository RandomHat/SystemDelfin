package model;

public class MemberFee {
    private final int PASSIVE_FEE = 500;
    private final int JUNIOR_FEE = 1000;
    private final int SENIOR_FEE = 1600;
    private final double PENSION_REBATE_MULTIPLIER = 0.25;

    public int getJUNIOR_FEE(){
        return JUNIOR_FEE;
    }

    public int getSENIOR_FEE() {
        return SENIOR_FEE;
    }

    public double getPENSION_REBATE_MULTIPLIER() {
        return PENSION_REBATE_MULTIPLIER;
    }

    public int getPASSIVE_FEE() {
        return PASSIVE_FEE;
    }
}
