package com.j4nu5.maticatalog;


import android.content.Context;

import com.j4nu5.maticatalog.model.Matic;
import com.j4nu5.maticatalog.model.Suzuki;
import com.j4nu5.maticatalog.model.Yamaha;
import com.j4nu5.maticatalog.model.Vespa;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Matic> matics = new ArrayList<>();

    private static List<Yamaha> initDataYamaha(Context ctx) {
        List<Yamaha> yamahas = new ArrayList<>();
        yamahas.add(new Yamaha("Soul GT", "Rp 17.300.000,-* ",
                "Maju Dengan Gagah ,125 CC High Performance, Blue Core Engine, Wide Tire, LED Head Light", R.drawable.yamaha_soulgt));
        yamahas.add(new Yamaha("Gear 125s", "Rp 17.350.000,-* ",
                "Let's Gear Up! Matic Multiguna", R.drawable.yamaha_gear));
        yamahas.add(new Yamaha("FreeGo S", "Rp 23.190.000,-* ",
                "The Amazing Matic", R.drawable.yamaha_freego));
        yamahas.add(new Yamaha("FreeGo", "Rp 19.275.000,-* ",
                "The Amazing Matic", R.drawable.yamaha_freego_2));
        yamahas.add(new Yamaha("XRide", "Rp 18.690.000,-* ",
                "Live in a Adventure", R.drawable.yamaha_xride));
        return yamahas;
    }

    private static List<Vespa> initDataVespa(Context ctx) {
        List<Vespa> vespas = new ArrayList<>();
        vespas.add(new Vespa("S", "Rp 39.000.000,-* ",
                "New Vespa S also undergoes enhancement in the functionality for better riding experience. In order to provide more control and comfort for both rider and passenger, new Vespa S has new shaped footrest.", R.drawable.vespa_s));
        vespas.add(new Vespa("LX", "Rp 37.500.000,-* ",
                "It comes with a new refreshed design that combines heritage and modernity, providing comfort to enhance a better riding experience and has uncompromised safety features.", R.drawable.vespa_lx));
        vespas.add(new Vespa("GTV", "Rp 155.000.000,-* ",
                "Characterised by the large body made strictly in steel, perfect for moving about elegantly in the city but always ready for travel and adventure.", R.drawable.vespa_gtv));
        vespas.add(new Vespa("primavera (RED)", "Rp 53.600.000,-* ",
                "(VESPA PRIMAVERA)RED is the new chapter in a great story of beauty, enthusiasm and solidarity. It represents the evolution of a style, the meeting with modernism that enhances the elegance of the original design.", R.drawable.vespa_primavera_red));
        vespas.add(new Vespa("GTS RACING SIXTIES", "Rp 157.000.000,-* ",
                "Vespa goes back in time to those fascinating 60’s to celebrate the glory of those racing days with a unique Vespa range inspired by classic sportiness.", R.drawable.vespa_gts));
                return vespas;
    }

    private static List<Suzuki> initDataSuzuki(Context ctx) {
        List<Suzuki> suzukis = new ArrayList<>();
        suzukis.add(new Suzuki("Address", "Rp 17.550.000,-* ",
                "Suzuki Motor Address Playful. It's so ME!", R.drawable.suzuki_address));
        suzukis.add(new Suzuki("Address FI", "Rp 17.400.000,-*",
                "Bebas berkendara,Dinamis bergaya", R.drawable.suzuki_address2));
        suzukis.add(new Suzuki("Nex II", "Rp 16.200.000,-*",
                "Motor Matic Stylish, Modern, dan Futuristik", R.drawable.suzuki_nex2));
        suzukis.add(new Suzuki("Nex II Cross", "Rp 16.220.000,-*",
                "Dengan naked handle bar yang semakin sporty untuk teman berkendara", R.drawable.suzuki_nex2x));
        suzukis.add(new Suzuki("Nex II Fancy", "Rp 16.900.000,-*",
                "Motor Matic Stylish, Modern, dan Futuristik", R.drawable.suzuki_nex2f));
        return suzukis;
    }

    private static void initAllHewans(Context ctx) {
        matics.addAll(initDataVespa(ctx));
        matics.addAll(initDataYamaha(ctx));
        matics.addAll(initDataSuzuki(ctx));
    }

    public static List<Matic> getAllHewan(Context ctx) {
        if (matics.size() == 0) {
            initAllHewans(ctx);
        }
        return matics;
    }

    public static List<Matic> getHewansByTipe(Context ctx, String jenis) {
        List<Matic> hewansByType = new ArrayList<>();
        if (matics.size() == 0) {
            initAllHewans(ctx);
        }
        for (Matic h : matics) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
