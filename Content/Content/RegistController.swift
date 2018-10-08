//
//  RegistController.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class RegistController: UIViewController {

    @IBOutlet weak var registBtn: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        registBtn.layer.cornerRadius = 5
        registBtn.layer.masksToBounds = true
        // Do any additional setup after loading the view.
    }


    @IBAction func didClickRegistBtn(_ sender: UIButton) {
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "MainController")
    
        let nav = UINavigationController(rootViewController: vc)
        UIApplication.shared.keyWindow?.rootViewController = nav
        
        
        
        
        
    }
    
}
