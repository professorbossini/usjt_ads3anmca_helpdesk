package br.com.bossini.usjt_ads3anmca_helpdesk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView chamadosListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        chamadosListView = findViewById(R.id.chamadosListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nomeFila");
        List <String> chamados = busca (nomeFila);
        ArrayAdapter <String> adapter =
                new ArrayAdapter<>(
                            this,
                            android.R.layout.simple_list_item_1,
                            chamados
        );
        chamadosListView.setAdapter(adapter);
        /*chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/

        chamadosListView.setOnItemClickListener(
                (adapterView, view, position, id) ->{
            Intent intent =
                    new Intent (this, DetalhesChamadoActivity.class);
            String chamado = chamados.get(position);
            intent.putExtra("chamado_selecionado", chamado);
            startActivity(intent);
        });


    }

    public List <String> busca (String nomeFila){
        List <String> chamados = geraListaChamados();
        if (nomeFila == null || nomeFila.isEmpty())
            return chamados;
        List <String> subLista = new ArrayList<>();
        for (String chamado: chamados){
           if (chamado.toLowerCase().contains(nomeFila.toLowerCase()))
               subLista.add(chamado);
        }
        return subLista;
    }


    public List<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Desktops: Computador da secretária quebrado.");
        lista.add("Telefonia: Telefone não funciona.");
        lista.add("Redes: Manutenção no proxy.");
        lista.add("Servidores: Lentidão generalizada.");
        lista.add("Novos Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão.");
        lista.add("Novos Projetos: Rede MPLS");
        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
        lista.add("Manutenção Sistema ERP: erro contábil");
        lista.add("Novos Projetos: Gestão de Orçamento");
        lista.add("Novos Projetos: Big Data");
        lista.add("Redes: Internet com lentidão");
        lista.add("Novos Projetos: Chatbot");
        lista.add("Desktops: troca de senha");
        lista.add("Desktops: falha no Windows");
        lista.add("Novos Projetos: ITIL V3");
        lista.add("Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }
}
