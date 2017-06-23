package flyweight;

import java.util.ArrayList;

/**
 *
 * @author cristovao
 */
public class FlyweightFactory {
    protected ArrayList<EditorFlyweight> flyweights;
    public enum caracteres{
        a,b,c,d,e,f,g;
    }
    public FlyweightFactory(){
        flyweights = new ArrayList<EditorFlyweight>();
        flyweights.add(new EditorConcretFlyweight('a'));
        flyweights.add(new EditorConcretFlyweight('b'));
        flyweights.add(new EditorConcretFlyweight('c'));
        flyweights.add(new EditorConcretFlyweight('d'));
        flyweights.add(new EditorConcretFlyweight('e'));
        flyweights.add(new EditorConcretFlyweight('f'));
        flyweights.add(new EditorConcretFlyweight('g'));
    }
    public EditorFlyweight getFlyweight(caracteres caract){
        switch(caract){
            case a:
                return flyweights.get(0);
            case b:
                return flyweights.get(1);
            case c:
                return flyweights.get(2);
            case d:
                return flyweights.get(3);
            case e:
                return flyweights.get(4);
            case f:
                return flyweights.get(5);
            case g:
                return flyweights.get(6);
            default:
                return flyweights.get(7);
        
        }
    }
}
