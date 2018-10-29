//
//  ChatsCell.swift
//  Content
//
//  Created by fcn on 2018/10/23.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit

class ChatsCell: UITableViewCell {
    
    
    
    @IBOutlet weak var content: UILabel!
    @IBOutlet weak var chatCount: UILabel!
    
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
