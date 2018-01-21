//Jefferson 
//lab9
//Implement a Java class gInt (Gaussian Integer) and write a JUnit test suite.


public class gInt {

    private int aR = 0;
    private int bI = 0;

    gInt(int r){
        this.aR = r;
    }
    public gInt(int r, int i){
        this.aR = r;
        this.bI = i;
    }

    public int real(){
        return aR;
    }

    public int imag(){
        return bI;
    }

    public gInt add(gInt rhs){

        return new gInt((aR + rhs.real()), (bI + rhs.imag()));
    }

    public gInt multiply(gInt rhs){

       return new gInt((aR * rhs.real()) - (bI * rhs.imag()), (aR * rhs.imag()) + (bI * rhs.real()));

    }
    //use the paythagorean theorem formula
    public float norm() { return (float) (Math.sqrt((aR * aR) + (bI * bI))); }

}

