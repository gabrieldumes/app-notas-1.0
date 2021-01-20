package com.gabriel.notas10.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Nota  implements Parcelable {

    private String titulo, nota;

    public Nota(){

    }

    public Nota(String titulo, String nota){

        this.titulo = titulo;
        this.nota = nota;
    }

    protected Nota(Parcel in) {
        titulo = in.readString();
        nota = in.readString();
    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    //Métodos da Parceable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(nota);
    }
}
