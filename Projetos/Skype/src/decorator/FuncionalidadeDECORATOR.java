/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author cristovao
 */
public abstract class FuncionalidadeDECORATOR extends FuncionalidadeCOMPONENT{
    protected FuncionalidadeCOMPONENT funcionalidadeDecorada;
    public FuncionalidadeDECORATOR(FuncionalidadeCOMPONENT funcionalidadeDecorada){
        this.funcionalidadeDecorada = funcionalidadeDecorada;
    }
}
