package a2.t1mo.mobjav.a816.myapplication.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by polialva on 9/11/16.
 */
public class GenerosListContainer {

    @SerializedName("genres")
    private List<Generos> listaDeGeneros;

    public List<Generos> getListaDeGeneros() {
        return listaDeGeneros;
    }

    public void setListaDeGeneros(List<Generos> listaDeGeneros) {
        this.listaDeGeneros = listaDeGeneros;
    }
}
