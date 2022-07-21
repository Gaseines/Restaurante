package br.com.gsn.restaurante.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Carrinho.Carrinho;
import br.com.gsn.restaurante.Cartao.Cartao;
import br.com.gsn.restaurante.Endereco.Endereco;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "restaurante";
    private static final String TABLE_ENDERECO = "endereco";
    private static final String TABLE_CARTAO = "cartao";
    private static final String TABLE_CARRINHO = "carrinho";


    private static final String CREATE_TABLE_ENDERECO = "CREATE TABLE " + TABLE_ENDERECO + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(100), " +
            "rua VARCHAR(100), " +
            "bairro VARCHAR(100), " +
            "numero VARCHAR(10), " +
            "adicional VARCHAR(100));";


    private static final String CREATE_TABLE_CARRINHO = "CREATE TABLE " + TABLE_CARRINHO + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(100), " +
            "preco VARCHAR(100));";

    private static final String CREATE_TABLE_CARTAO = "CREATE TABLE " + TABLE_CARTAO + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(100), " +
            "numero VARCHAR(100), " +
            "data VARCHAR(15), " +
            "titular VARCHAR(100), " +
            "cod VARCHAR(5));";

    private static final String DROP_TABLE_ENDERECO = "DROP TABLE IF EXISTS " + TABLE_ENDERECO;
    private static final String DROP_TABLE_CARTAO = "DROP TABLE IF EXISTS " + TABLE_ENDERECO;
    private static final String DROP_TABLE_CARRINHO = "DROP TABLE IF EXISTS " + TABLE_CARRINHO;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ENDERECO);
        db.execSQL(CREATE_TABLE_CARTAO);
        db.execSQL(CREATE_TABLE_CARRINHO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE_ENDERECO);
        db.execSQL(DROP_TABLE_CARTAO);
        db.execSQL(DROP_TABLE_CARRINHO);
        onCreate(db);

    }

    /*Inicio CRUD Endereço*/
    public long createEndereco(Endereco e) {
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

    public long updateEndereco(Endereco e) {
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

    public long deleteEndereco(Endereco e) {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_ENDERECO, "_id = ?", new String[]{String.valueOf(e.getId())});
        db.close();
        return id;
    }

    public void getAllEndereco(Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome"};
        Cursor data = db.query(TABLE_ENDERECO, columns, null,
                null, null, null, "nome");
        int[] to = {R.id.textViewIdListarEndereco, R.id.textViewNomeListarEndereco};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.endereco_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }

    public Endereco getByIdEndereco(int id) {
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

    /*Inicio CRUD Cartao*/
    public long createCartao(Cartao c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());
        cv.put("numero", c.getNumero());
        cv.put("data", c.getData());
        cv.put("titular", c.getTitular());
        cv.put("cod", c.getCod());
        long id = db.insert(TABLE_CARTAO, null, cv);
        db.close();
        return id;
    }

    public long updateCartao(Cartao c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());
        cv.put("numero", c.getNumero());
        cv.put("data", c.getData());
        cv.put("titular", c.getTitular());
        cv.put("cod", c.getCod());
        long id = db.update(TABLE_CARTAO, cv, "_id = ?", new String[]{String.valueOf(c.getId())});
        db.close();
        return id;
    }

    public long deleteCartao(Cartao c) {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_CARTAO, "_id = ?", new String[]{String.valueOf(c.getId())});
        db.close();
        return id;
    }

    public void getAllCartao(Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "numero"};
        Cursor data = db.query(TABLE_CARTAO, columns, null,
                null, null, null, "numero");
        int[] to = {R.id.textViewIdListarCartao, R.id.textViewNumeroListarCartao};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.cartao_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }

    public Cartao getByIdCartao(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "numero", "data", "titular", "cod"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_CARTAO, columns, "_id = ?", args, null,
                null, null);
        data.moveToFirst();
        Cartao c = new Cartao();
        c.setId(data.getInt(0));
        c.setNome(data.getString(1));
        c.setNumero(data.getString(2));
        c.setData(data.getString(3));
        c.setTitular(data.getString(4));
        c.setCod(data.getString(5));
        data.close();
        db.close();
        return c;
    }
    /*Fim CRUD Cartao*/

    /*Inicio CRUD Carrinho*/


    public long createCarrinho(Carrinho r) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", r.getNome());
        cv.put("preco", r.getPreco());
        long id = db.insert(TABLE_CARRINHO, null, cv);
        db.close();
        return id;

    }

    public long updateCarrinho(Carrinho r) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", r.getNome());
        cv.put("preco", r.getPreco());
        long id = db.update(TABLE_CARRINHO, cv, "_id = ?", new String[]{String.valueOf(r.getId())});
        db.close();
        return id;
    }

    public long deleteCarrinho(Carrinho r) {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.delete(TABLE_CARRINHO, "_id = ?", new String[]{String.valueOf(r.getId())});
        db.close();
        return id;
    }

    public void getAllCarrinho(Context context, ListView lv) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "preco"};
        Cursor data = db.query(TABLE_CARRINHO, columns, null,
                null, null, null, "nome");
        int[] to = {R.id.idCarrinho, R.id.nomeCarrinho, R.id.precoCarrinho};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.carrinho_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();

    }
    public Carrinho getByIdCarrinho(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "preco"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_CARRINHO, columns, "_id = ?", args, null,
                null, null);
        data.moveToFirst();
        Carrinho r = new Carrinho();
        r.setId(data.getInt(0));
        r.setNome(data.getString(1));
        r.setPreco(data.getString(2));
        data.close();
        db.close();
        return r;
    }

    /*Fim CRUD Carrinho*/
}