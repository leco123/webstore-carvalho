package com.org.carvalho.webstore.api.apis_externas.ceps.api.interfaces;

import com.org.carvalho.webstore.api.apis_externas.ceps.api.dtos.EnderecoCEPAPIDTO;

 public interface ConsumeApiCEP {
    EnderecoCEPAPIDTO bucarEndereco(String cep);
}
