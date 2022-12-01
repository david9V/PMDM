package ch.makery.address.model;

public class ConversorMonedasImpl implements Conversor{

    @Override
    public float convertirA_B(float n, float mult) {
        float res;
        res = n * mult;
        return res;
    }

    @Override
    public float convertirB_A(float n, float mult) {
        float res;
        res = n * (2 - mult);
        return res;
    }
}
