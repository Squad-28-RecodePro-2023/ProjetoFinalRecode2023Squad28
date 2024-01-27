package com.beautyAcademy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beautyAcademy.entities.Aluno;
import com.beautyAcademy.entities.UserDetailsImpl;
import com.beautyAcademy.repositories.AlunoRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Aluno aluno = alunoRepository.findByEmail(email);

        return new UserDetailsImpl(aluno);
    }    
}