package com.mxdlzg.rental.domain.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilterParams {
    private List<OptionsCar> optionsCar;
    private List<OptionsKV> optionsSeat;
    private List<OptionsKV> optionsPrice;
    private List<OptionsKV> optionsBrand;

    public FilterParams(List<OptionsCar> optionsCar, List<OptionsKV> optionsSeat, List<OptionsKV> optionsPrice, List<OptionsKV> optionsBrand) {
        this.optionsCar = optionsCar;
        this.optionsSeat = optionsSeat;
        this.optionsPrice = optionsPrice;
        this.optionsBrand = optionsBrand;
    }

    public List<OptionsCar> getOptionsCar() {
        return optionsCar;
    }

    public void setOptionsCar(List<OptionsCar> optionsCar) {
        this.optionsCar = optionsCar;
    }

    public List<OptionsKV> getOptionsSeat() {
        return optionsSeat;
    }

    public void setOptionsSeat(List<OptionsKV> optionsSeat) {
        this.optionsSeat = optionsSeat;
    }

    public List<OptionsKV> getOptionsPrice() {
        return optionsPrice;
    }

    public void setOptionsPrice(List<OptionsKV> optionsPrice) {
        this.optionsPrice = optionsPrice;
    }

    public List<OptionsKV> getOptionsBrand() {
        return optionsBrand;
    }

    public void setOptionsBrand(List<OptionsKV> optionsBrand) {
        this.optionsBrand = optionsBrand;
    }
}
