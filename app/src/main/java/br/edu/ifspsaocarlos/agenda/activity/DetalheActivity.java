package br.edu.ifspsaocarlos.agenda.activity;

<<<<<<< HEAD
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
=======
import android.content.Intent;
>>>>>>> origin/master
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifspsaocarlos.agenda.R;
<<<<<<< HEAD
//import br.edu.ifspsaocarlos.agenda.data.ContatoDAO;
import br.edu.ifspsaocarlos.agenda.contentprovider.ContatoProvider;
=======
import br.edu.ifspsaocarlos.agenda.data.ContatoDAO;
>>>>>>> origin/master
import br.edu.ifspsaocarlos.agenda.model.Contato;

public class DetalheActivity extends AppCompatActivity {
    private Contato c;
<<<<<<< HEAD
    //private ContatoDAO cDAO;

    Uri uriContato= ContatoProvider.Contatos.CONTENT_URI;

=======
    private ContatoDAO cDAO;
>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("contact"))
        {

            this.c = (Contato) getIntent().getSerializableExtra("contact");
            EditText nameText = (EditText)findViewById(R.id.editText1);
            nameText.setText(c.getNome());

            EditText foneText = (EditText)findViewById(R.id.editText2);
            foneText.setText(c.getFone());

            EditText emailText = (EditText)findViewById(R.id.editText3);
            emailText.setText(c.getEmail());

            EditText txtFone2 = (EditText)findViewById(R.id.edtFone2);
            txtFone2.setText(c.getFone2());

            EditText txtNiver = (EditText)findViewById(R.id.edtNiver);
            txtNiver.setText(c.getNiver());

            int pos =c.getNome().indexOf(" ");
            if (pos==-1)
                pos=c.getNome().length();

            setTitle(c.getNome().substring(0,pos));
        }

<<<<<<< HEAD
      //  cDAO = new ContatoDAO(this);
=======
        cDAO = new ContatoDAO(this);
>>>>>>> origin/master

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
        if (!getIntent().hasExtra("contact"))
        {
            MenuItem item = menu.findItem(R.id.delContato);
            item.setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.salvarContato:
                salvar();
                return true;
            case R.id.delContato:
                //cDAO.deleteContact(c);
                getContentResolver().delete(ContentUris.withAppendedId(uriContato, c.getId()), null,null);

                Toast.makeText(getApplicationContext(), "Removido com sucesso", Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent();
                setResult(RESULT_OK,resultIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void salvar()
    {
        String name = ((EditText) findViewById(R.id.editText1)).getText().toString();
        String fone = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String email = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String fone2 = ((EditText) findViewById(R.id.edtFone2)).getText().toString();
        String niver = ((EditText) findViewById(R.id.edtNiver)).getText().toString();

<<<<<<< HEAD
        ContentValues valores=new ContentValues();
        valores.put(ContatoProvider.Contatos.KEY_NOME,  name);
        valores.put(ContatoProvider.Contatos.KEY_FONE,  fone);
        valores.put(ContatoProvider.Contatos.KEY_EMAIL, email);
        valores.put(ContatoProvider.Contatos.KEY_FONE2, fone2);
        valores.put(ContatoProvider.Contatos.KEY_NIVER, niver);


=======
>>>>>>> origin/master
        if (c==null)
        {
            c = new Contato();
            c.setNome(name);
            c.setFone(fone);
            c.setEmail(email);
            c.setFone2(fone2);
            c.setNiver(niver);

<<<<<<< HEAD
            //cDAO.createContact(c);
            getContentResolver().insert(uriContato,valores);

=======
            cDAO.createContact(c);
>>>>>>> origin/master
            Toast.makeText(this, "Incluído com sucesso", Toast.LENGTH_SHORT).show();
        }
        else
        {
            c.setNome(name);
            c.setFone(fone);
            c.setEmail(email);
            c.setFone2(fone2);
            c.setNiver(niver);

<<<<<<< HEAD
            //cDAO.updateContact(c);
            getContentResolver().update(ContentUris.withAppendedId(uriContato, c.getId()), valores, null, null);

=======
            cDAO.updateContact(c);
>>>>>>> origin/master
            Toast.makeText(this, "Alterado com sucesso", Toast.LENGTH_SHORT).show();
        }

        Intent resultIntent = new Intent();
        setResult(RESULT_OK,resultIntent);
        finish();
    }


}
