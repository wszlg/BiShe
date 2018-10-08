//
//  LoginController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class LoginController: UIViewController {

    @IBOutlet weak var registBtn: UIButton!
    @IBOutlet weak var loginBtn: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        
        registBtn.layer.cornerRadius = 5
        registBtn.layer.masksToBounds = true
        
        loginBtn.layer.cornerRadius = 5
        loginBtn.layer.masksToBounds = true
        
        
    }
    
    
    @IBAction func didClickLogin(_ sender: UIButton) {
        
        view.endEditing(true)
        
        
        
    }
    

//    @IBAction func didClickRegist(_ sender: UIButton) {
//        
//        
//    }
    

}
