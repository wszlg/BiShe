//
//  TextDetailCell.swift
//  Content
//
//  Created by fcn on 2018/10/10.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class TextDetailCell: UITableViewCell {
    
    
    @IBOutlet weak var title: UILabel!
    
    @IBOutlet weak var content: UILabel!
    

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}