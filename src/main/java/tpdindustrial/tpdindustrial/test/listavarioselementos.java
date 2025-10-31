package tpdindustrial.tpdindustrial.test;

/**
 *
 * @author USUARIO
 */
public enum listavarioselementos {
    PRODUCTOA(9),
    PRODUCTOB(8),
    PRODUCTOC(7),
    PRODUCTOD(6),
    PRODUCTOE(5);
    
    public final int elementos;

    listavarioselementos(int p) {
      this.elementos = p;
    }

    public int getElementos() {
        return elementos;
    }
    
    
    
}
