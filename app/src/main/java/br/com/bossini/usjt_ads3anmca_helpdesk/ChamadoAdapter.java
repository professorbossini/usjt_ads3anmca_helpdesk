package br.com.bossini.usjt_ads3anmca_helpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChamadoAdapter extends ArrayAdapter <Chamado> {

    private Context context;
    private List <Chamado> chamados;

    public ChamadoAdapter (Context context, List <Chamado> chamados){
        super(context, -1, chamados);
        this.chamados = chamados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Chamado chamadoDaVez = getItem(position);
        ChamadoViewHolder vh = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    R.layout.list_item,
                    parent,
                    false
            );
            vh = new ChamadoViewHolder();
            vh.filaIconImageView =
                    convertView.findViewById(
                            R.id.filaIconImageView
                    );
            vh.descricaoChamadoNaFilaTextView =
                    convertView.findViewById(
                            R.id.descricaoChamadoNaFilaTextView
                    );
            vh.statusChamadoNaFilaTextView =
                    convertView.findViewById(
                            R.id.statusChamadoNaFilaTextView
                    );

            vh.dataAberturaChamadoNaFilaTextView =
                    convertView.findViewById(
                            R.id.dataAberturaChamadoNaFilaTextView
                    );
            vh.dataFechamentoChamadoNaFilaTextView =
                    convertView.findViewById(
                            R.id.dataFechamentoChamadoNaFilaTextView
                    );
            convertView.setTag(vh);
        }

        vh = (ChamadoViewHolder) convertView.getTag();
        vh.filaIconImageView.setImageResource(
                chamadoDaVez.getFila().getIconId()
        );
        vh.descricaoChamadoNaFilaTextView.setText(
                chamadoDaVez.getDescricao()
        );
        vh.dataAberturaChamadoNaFilaTextView.setText(
                DateHelper.format(
                        chamadoDaVez.getDataAbertura()
                )
        );
        if (chamadoDaVez.getDataFechamento() != null){
            DateHelper.format(
                    chamadoDaVez.getDataFechamento()
            );
        }
        vh.statusChamadoNaFilaTextView.setText(
                chamadoDaVez.getStatus()
        );
        return convertView;
    }
}
