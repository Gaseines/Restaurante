package br.com.gsn.restaurante.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.endereco.Endereco;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "restaurante";
    private static final String TABLE_ENDERECO = "endereco";

    private static final String CREATE_TABLE_ENDERECO = "CREATE TABLE " + TABLE_ENDERECO + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(100), " +
            "rua VARCHAR(100), " +
            "bairro VARCHAR(100), " +
            "numero VARCHAR(10), " +
            "adicional VARCHAR(100));";

    private static final String DROP_TABLE_ENDERECO = "DROP TABLE IF EXISTS " + TABLE_ENDERECO;


    public  DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ENDERECO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE_ENDERECO);
        onCreate(db);

    }

    /*Inicio CRUD Endereço*/
    public long createEndereco (Endereco e){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", e.getNome());
        cv.put("rua", e.getRua());
        cv.put("bairro", e.getBairro());
        cv.put("numero", e.getNumero());
        cv.put("adicional", e.getAdicional());
        long id = db.insert(TABLE_ENDERECO, null, cv);
        db.close();
        return id;
    }

    public long updateEndereco (Endereco e){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", e.getNome());
        cv.put("rua", e.getRua());
        cv.put("bairro", e.getBairro());
        cv.put("numero", e.getNumero());
        cv.put("adicional", e.getAdicional());
        long id = db.update(TABLE_ENDERECO, cv, "_id = ?", new String[]{String.valueOf(e.getId())});
        db.close();
        return id;
    }
    public long deleteEndereco (Endereco e){
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_ENDERECO, "_id = ?", new String[]{String.valueOf(e.getId())});
        db.close();
        return id;
    }
    public void getAllEndereco(Context context, ListView lv){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome"};
        Cursor data = db.query(TABLE_ENDERECO, columns, null ,
                null, null, null, "nome");
        int[] to = {R.id.textViewIdListarEndereco, R.id.textViewNomeListarEndereco};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.endereco_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }
    public Endereco getByIdEndereco(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "rua", "bairro", "numero", "adicional"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_ENDERECO, columns, "_id = ?", args, null,
                null, null);
        data.moveToFirst();
        Endereco e = new Endereco();
        e.setId(data.getInt(0));
        e.setNome(data.getString(1));
        e.setRua(data.getString(2));
        e.setBairro(data.getString(3));
        e.setNumero(data.getString(4));
        e.setAdicional(data.getString(5));
        data.close();
        db.close();
        return e;
    }

    /*Fim CRUD Endereço*/
}
