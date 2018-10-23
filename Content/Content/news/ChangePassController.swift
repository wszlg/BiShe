//
//  ChangePassController.swift
//  Content
//
//  Created by fcn on 2018/10/23.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import Alamofire

class ChangePassController: UIViewController {
    
    
    @IBOutlet weak var pass: UITextField!
    @IBOutlet weak var passConfirm: UITextField!
    
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    @IBAction func didClickButton(_ sender: Any) {
        
        if (pass.text?.isEmpty)! || (passConfirm.text?.isEmpty)! || (passConfirm.text != pass.text) {
            SVTool.showError(info: "输入不正确")
            return
        }
        
        
        let m_parameters: Parameters = [
            "userid": DataTool.getInfo(key: "userid") as! String,
            "password": pass.text!
        ]
        NetTool.Get(url: "\(BACKURL)changPass.action", parameters: m_parameters) { (json) in
            if let js = json {
                let status = js["status"].intValue
                if status == 1 {
                    SVTool.showSuccess(info: "修改成功")
                }
            }
        }
        
    }
    

}
